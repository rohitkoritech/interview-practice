## Design Wise's Real-Time Scam Prevention System

### 1. Requirements

The system should evaluate every eligible transfer before money movement and return one of four decisions:

- **ALLOW** - proceed normally
- **CHALLENGE** - ask the customer for additional confirmation/verification
- **REVIEW** - hold the transfer for manual/operational review
- **BLOCK** - reject the transfer

We exclude refunds initially.

Non-functional requirements:

- P95 risk-decision latency <100 ms
- Highly available and horizontally scalable
- Support very high global transaction volume
- Minimize false negatives because missed scams are costly
- Also minimize false positives because excessive challenges/blocks create customer friction
- Financial transactions must be strongly consistent and idempotent
- Risk decisions must be auditable

---

## 2. High-Level Architecture

```text
                         ┌──────────────────────┐
                         │      Customer         │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │   Transfer Service   │
                         └──────────┬───────────┘
                                    │
                             synchronous call
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │     Risk Service     │
                         └──────────┬───────────┘
                                    │
                   ┌────────────────┼────────────────┐
                   │                │                │
                   ▼                ▼                ▼
            Feature Store     Rule Engine       ML Model
                   │                │                │
                   └────────────────┼────────────────┘
                                    │
                                    ▼
                             Decision Engine
                                    │
                         ┌──────────┼──────────┐
                         ▼          ▼          ▼
                      ALLOW     CHALLENGE   REVIEW/BLOCK
                         │
                         ▼
                  Transfer Execution
```

The Transfer Service is responsible for the financial transaction, while the Risk Service is responsible for determining whether the transfer is safe.

---

## 3. Risk Features

The Risk Service uses:

**Current transaction signals**

- Sender
- Recipient
- Amount/currency
- Destination
- Device/session information
- Location/context

**Historical behavioral signals**

- Average transaction amount
- Transaction frequency/velocity
- New recipient
- Historical sender-recipient relationship
- Typical destination
- Recent behavioral changes
- Previous risk decisions

I would not query the entire transaction history synchronously because that would hurt the <100 ms latency target.

Instead, transaction events are processed asynchronously to build a low-latency Feature Store.

```text
Transfer Service
       │
       ▼
    Outbox
       │
       ▼
     Kafka
       │
       ▼
Feature Processor
       │
       ▼
 Feature Store
```

The Transaction DB remains the source of truth; the Feature Store is an optimized read model.

---

## 4. Real-Time Features and Consistency

Not every feature needs strong consistency.

Historical/ML features can tolerate some staleness.

However, critical features such as:

```text
amount transferred in last 1 hour
number of transfers in last 10 minutes
```

may need the latest transaction immediately.

For these, I would use atomic counters, potentially with time buckets:

```text
customerId + timeBucket → counter
```

An atomic increment prevents concurrent updates from overwriting each other.

So the Risk Engine combines:

```text
Historical Features
        +
Real-Time Counters
        +
Current Transaction
        ↓
Risk Decision
```

---

## 5. Risk Decision Engine

I would separate the decision engine from the actual rules and ML model.

```text
                    ┌── Rules Engine ──┐
                    │                  │
Features ───────────┼── ML Model ──────┼──► Decision Engine
                    │                  │
Current Transfer ──┴──────────────────┘
                                           │
                                           ▼
                              ALLOW / CHALLENGE /
                              REVIEW / BLOCK
```

Rules should be **data-driven and versioned**, rather than hard-coded.

A rule deployment should support:

- Validation
- Versioning
- Gradual rollout
- Rollback
- Auditability

Each risk decision records the rule/model version used so that we can later explain why a transaction was challenged or blocked.

---

## 6. Idempotency

The Transfer Service should accept an idempotency key.

```text
Client
   │
   ▼
Transfer Service
   │
   ├── check idempotency key
   │
   ▼
Risk Check
   │
   ▼
Money Movement
```

However, idempotency must extend to the actual money movement.

The downstream ledger/payment service should also accept the unique `transferId`.

If the service crashes after money movement but before marking the transfer as completed, a retry with the same `transferId` will return the existing result instead of moving the money twice.

The key principle is:

> My database alone cannot guarantee exactly-once execution when money movement happens in another system. The downstream money-movement operation must also be idempotent or provide an equivalent transactional guarantee.

---

## 7. Event Processing and Failure Handling

The Outbox Pattern solves:

```text
Database update
       +
Kafka event
```

being inconsistent.

The Feature Processor is an idempotent consumer.

We use an `eventId`, or something like:

```text
transferId + eventType + version
```

to identify duplicate events.

If Kafka delivers the same event twice, the processor recognizes the duplicate and doesn't apply the feature update twice.

---

## 8. Failure Handling

### Risk Service unavailable

I would not blindly fail open or fail closed.

Use a **risk-based degraded mode**:

```text
Risk Service unavailable
          │
          ▼
Cached features + critical local rules
          │
      ┌───┼────┐
      ▼   ▼    ▼
    Low  Medium High
    │     │      │
  Allow Challenge Block/Review
```

For particularly high-risk operations, we can fail closed.

### Feature Store unavailable

Use cached features where available and fall back to critical signals/rules available locally.

We should also have strict timeouts so dependencies don't cause the risk decision to exceed the latency target.

---

## 9. Multi-Region

Deploy Risk Services and Feature Stores regionally.

```text
                    Global Routing
                    /            \
                   /              \
              Europe             Asia
                │                  │
          Risk Service        Risk Service
          Feature Store       Feature Store
                │                  │
                └──── async ───────┘
                   replication
```

Behavioral features can be asynchronously replicated because some staleness is acceptable.

However, the financial transaction itself must have an authoritative source with strong consistency.

If a region fails, traffic can fail over to another region.

---

## 10. Scalability

Risk Services are stateless and can scale horizontally:

```text
                 Load Balancer
                /      |      \
               /       |       \
          Risk-1    Risk-2    Risk-3
```

Kafka allows asynchronous feature processing to scale through partitions and consumer groups.

For simple high-frequency counters, use atomic distributed counters rather than forcing all updates for a customer through one Kafka partition.

Rate limiting can additionally protect the system from abusive traffic.

---

## 11. Observability

I would monitor three categories.

### System metrics

- P95/P99 latency
- Error rate
- Availability
- Feature Store latency
- Kafka consumer lag
- Dependency failures

### Risk/product metrics

- Scam detection rate
- Confirmed scam losses
- False-positive rate
- Challenge/block/review rate
- Customer drop-off
- Customer complaints

### Model/rule metrics

- Performance by rule/model version
- Risk-score distribution
- Precision/recall when ground truth becomes available
- Comparison between old and new rule versions

New rules/models should be rolled out gradually.

If scam losses decrease while false positives and customer friction remain within acceptable limits, continue the rollout. Otherwise, roll back.

---

## 12. Final Design Principle

The most important design trade-off is:

> **Keep the financial transaction strongly consistent and idempotent, while allowing the large-scale behavioral/ML feature pipeline to be asynchronous and eventually consistent.**

This gives us:

- Low-latency risk decisions
- High scalability
- Strong financial correctness
- Resilience to failures
- Flexible rule/model deployment
- Auditable risk decisions
- Minimal customer friction