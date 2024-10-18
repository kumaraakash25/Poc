import java.util.ArrayDeque;

public class SlidingWindowMyVersion {
    int requestCount;
    int slidingInterval;
    ArrayDeque<Long> deque;

    public SlidingWindowMyVersion(int requestCount, int slidingInterval) {
        this.requestCount = requestCount;
        this.slidingInterval = slidingInterval;
        deque = new ArrayDeque<>(requestCount);
    }

    public synchronized boolean allow() {
        boolean allowed = false;
        long currentTimestamp = System.currentTimeMillis() / 1000;
        while (deque.peekFirst() != null && currentTimestamp - deque.peekFirst() > slidingInterval) {
            deque.pollFirst();
        }
        if (deque.size() < requestCount ) {
            deque.offer(currentTimestamp);
            allowed = true;
        }
        System.out.println(deque.size());
        return allowed;
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowMyVersion lim = new SlidingWindowMyVersion(2, 10);

        lim.allow();
        lim.allow();
        Thread.sleep(10000);
        lim.allow();
        Thread.sleep(20000);
        lim.allow();
        lim.allow();
    }
}
