import java.util.LinkedList;

public class SlidingWindow {
    int windowSize; // 10 sec
    int maxRequests; // 100 requests
    public LinkedList<Long> list;

    public SlidingWindow(int windowSize, int maxRequests) {
        this.windowSize = windowSize;
        this.maxRequests = maxRequests;
        list = new LinkedList();
    }

    public boolean allowRequests() {
        long currentTime = System.currentTimeMillis() / 1000;
        while (!list.isEmpty() && list.getFirst() >= currentTime - windowSize) {
            list.removeFirst();
        }
        if (list.size() < maxRequests) {
            list.add(currentTime);
            return true;
        } else {
            return false;
        }
    }
}
