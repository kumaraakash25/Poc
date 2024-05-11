package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * How would u distribute load between multiple threads?
 */
public class MultipleThreads {

    private static ExecutorService service;
    private static Queue<Integer> queue = new LinkedList<>();
    private static ReentrantLock lock = new ReentrantLock();

    MultipleThreads(int threadPoolSize) {
        service = Executors.newFixedThreadPool(threadPoolSize);
        loadQueue();
    }

    public static void main(String[] args) throws InterruptedException {
        MultipleThreads t = new MultipleThreads(10);

        for (int i = 0; i < 100000000; i++) {
            queue.add(i);
        }
        Runnable run = () -> {
            while (true) {
                service.execute(() -> processQueue());
            }
        };
        run.run();
    }

    private static void processQueue() {
        lock.lock();
        try {
            if (!queue.isEmpty()) {
                Integer element = queue.poll();
                String result = Thread.currentThread().getName() + " Element" + element;
                System.out.println(result);
            }
        } finally {
            lock.unlock();
        }
    }

    private static void loadQueue() {
        AtomicInteger count = new AtomicInteger();
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            lock.lock();
            try {
                queue.add(1000000+ count.incrementAndGet());
            } finally {
                lock.unlock();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
