I'd model "money handled" as the total amount of successfully completed transfers in the previous 24 hours, counting each transfer exactly once.

The transfer system is already the source of truth for completed transfers. I don't want the metric calculation coupled synchronously to the transfer path, so I'll make it asynchronous.

The high-level flow is:

Transfer Service → Transactional Outbox → Kafka → Metric Aggregators → Bucket DB → Redis → Metric API.

When a transfer completes, the Transfer Service updates the transfer state and writes a `TransferCompleted` event to an outbox table in the same database transaction. An outbox publisher reliably publishes those events to Kafka. This avoids the failure case where the transfer commits but the Kafka publish fails.

Kafka is partitioned by `transferId` to distribute the load across consumers and also preserve ordering for events belonging to the same transfer.

The metric consumers process the events idempotently. Each event contains the transfer ID, completed timestamp, original amount/currency, and authoritative FX conversion information.

We convert the amount into a canonical currency, for example EUR, using the historical FX rate associated with the completed transfer. We store the original amount, FX rate, and converted amount so that the calculation is auditable and reproducible.

For the 24-hour sliding window, I would use fixed time buckets. If the product accepts minute-level accuracy, we can use one-minute buckets. If exact second-level semantics are required, I would use one-second buckets. Since there are only 86,400 one-second buckets in 24 hours, this is still a very small aggregate state.

The bucket store might look like:

bucket_start | amount_eur

Each completed transfer is mapped to a bucket using its `completedAt` timestamp.

The metric database is the durable source of truth for the aggregate. Concurrent updates to the same bucket use an atomic database increment/upsert, so two consumers updating the same bucket cannot overwrite each other.

For idempotency, I maintain a `processed_transfers` table with a unique constraint on `transferId`. The insert into this table and the bucket update happen in the same database transaction.

Conceptually:

BEGIN

INSERT transferId INTO processed_transfers
ON CONFLICT DO NOTHING

IF insert succeeded:
    UPDATE bucket
    SET amount = amount + convertedAmount

COMMIT

This gives us exactly-once effect on the metric even though Kafka itself provides at-least-once delivery. If the consumer crashes before committing the Kafka offset, the event is redelivered, but the unique constraint prevents the transfer from being counted again.

For out-of-order events, the bucket is determined from `completedAt`, not arrival time. A delayed event therefore updates its historical bucket as long as it is still within our accepted lateness/retention window.

For reads, I would put Redis in front of the bucket database. The aggregation pipeline can update the current metric in Redis, and the Metric API reads from Redis for low latency. Redis is only a cache, not the source of truth. If Redis fails, the API can fall back to the bucket DB and repopulate the cache. I would also use request coalescing to avoid a cache failure causing a thundering herd against the database.

I would not make a persistent running total an independent source of truth because that creates another state that can become inconsistent with the buckets. If we maintain a running total for faster reads, it should be treated as derived state and reconstructable from the bucket store.

Kafka also gives us recovery and backpressure. If consumers fall behind, we monitor consumer lag and scale the consumer group horizontally, assuming there are enough Kafka partitions. Kafka retains the events while consumers catch up. We don't drop events simply to reduce lag.

Finally, I would build a reconciliation process. The completed-transfer database remains the ultimate source of truth. A reconciliation job can independently read completed transfers for a time range, recompute the expected buckets, compare them with the metric bucket DB, and alert on discrepancies. If necessary, we can rebuild the affected buckets and atomically replace the derived state. Reconciliation should be isolated from the live aggregation path.

So the key design principles are:

1. Transfer DB is the business source of truth.
2. Outbox gives reliable event publication.
3. Kafka provides durable asynchronous processing and replay.
4. Idempotent consumers prevent duplicate effects.
5. Atomic bucket updates handle concurrency.
6. Time buckets make the 24-hour calculation efficient.
7. Redis provides a low-latency read path but is not authoritative.
8. Reconciliation lets us detect and repair derived-state discrepancies.