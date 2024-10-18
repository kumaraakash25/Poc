import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public class SlidingWindow {
    int windowDuration; // 10 sec
    int maxRequests; // 100 requests
    public ConcurrentLinkedQueue<Long> list;
    private final AtomicLong lastRequestTime = new AtomicLong(0);

    public SlidingWindow(int windowDuration, int maxRequests) {
        this.windowDuration = windowDuration;
        this.maxRequests = maxRequests;
        list = new ConcurrentLinkedQueue();
    }

    public boolean allowRequests() {
        long currentTime = System.currentTimeMillis() / 1000;
        while (!list.isEmpty() && list.peek() >= currentTime - windowDuration) {
            list.peek();
        }
        lastRequestTime.set(currentTime);
        if (list.size() < maxRequests) {
            list.add(lastRequestTime.get());
            return true;
        } else {
            return false;
        }
    }
}
