import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class CircuitBreaker {

    public enum State { CLOSED, OPEN, HALF_OPEN }

    private final int failureThreshold;      // failures to trip OPEN
    private final int successThreshold;      // successes in HALF_OPEN to close
    private final long waitDurationMillis;   // how long to stay OPEN before trying HALF_OPEN

    private final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);
    private final AtomicInteger failureCount = new AtomicInteger(0);
    private final AtomicInteger successCount = new AtomicInteger(0);
    private final AtomicLong openedAt = new AtomicLong(0);

    public CircuitBreaker(int failureThreshold, int successThreshold, long waitDurationMillis) {
        this.failureThreshold = failureThreshold;
        this.successThreshold = successThreshold;
        this.waitDurationMillis = waitDurationMillis;
    }

    public <T> T execute(Supplier<T> call, Supplier<T> fallback) {
        if (!allowRequest()) {
            return fallback.get();
        }
        try {
            T result = call.get();
            onSuccess();
            return result;
        } catch (Exception e) {
            onFailure();
            return fallback.get();
        }
    }

    private boolean allowRequest() {
        State current = state.get();

        if (current == State.OPEN) {
            long elapsed = System.currentTimeMillis() - openedAt.get();
            if (elapsed > waitDurationMillis) {
                // attempt transition OPEN -> HALF_OPEN
                if (state.compareAndSet(State.OPEN, State.HALF_OPEN)) {
                    successCount.set(0);
                }
                return true; // let this call through as a trial
            }
            return false; // still OPEN, fail fast
        }

        // CLOSED or HALF_OPEN both allow the call through
        return true;
    }

    private void onSuccess() {
        State current = state.get();
        if (current == State.HALF_OPEN) {
            int successes = successCount.incrementAndGet();
            if (successes >= successThreshold) {
                reset();
            }
        } else if (current == State.CLOSED) {
            failureCount.set(0); // reset streak on any success
        }
    }

    private void onFailure() {
        State current = state.get();
        if (current == State.HALF_OPEN) {
            trip();
        } else if (current == State.CLOSED) {
            int failures = failureCount.incrementAndGet();
            if (failures >= failureThreshold) {
                trip();
            }
        }
    }

    private void trip() {
        state.set(State.OPEN);
        openedAt.set(System.currentTimeMillis());
        failureCount.set(0);
    }

    private void reset() {
        state.set(State.CLOSED);
        failureCount.set(0);
        successCount.set(0);
    }

    public State getState() {
        return state.get();
    }

    // --- demo ---
    public static void main(String[] args) throws InterruptedException {
        CircuitBreaker cb = new CircuitBreaker(3, 2, 2000);

        Supplier<String> flakyService = () -> {
            if (Math.random() < 0.7) throw new RuntimeException("service down");
            return "success";
        };
        Supplier<String> fallback = () -> "fallback-response";

        for (int i = 0; i < 10; i++) {
            String result = cb.execute(flakyService, fallback);
            System.out.printf("Call %d: state=%s result=%s%n", i, cb.getState(), result);
            Thread.sleep(300);
        }
    }
}