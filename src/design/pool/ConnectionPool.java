package design.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPool {

    volatile BlockingQueue<Integer> queue;
    int connectCount;
    static ExecutorService service = Executors.newFixedThreadPool(5);

    ConnectionPool(int size) {
        connectCount = size;
        queue = new ArrayBlockingQueue<>(size);
        for (int i = 1; i <= size; i++) {
            queue.add(i);
        }
    }

    public Integer acquireConnection(String threadName) throws InterruptedException {
        // No blocking is required here because ABQ will do by itself
        Integer obj = queue.take();
        System.out.println("Acquired");
        return obj;
    }

    public void releaseConnection(String threadName, Integer conn) {
        if (conn != null) {
            queue.offer(conn);
            System.out.println("Released");
        }
    }

    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(5);
        Runnable task = () -> {
            try {
                String threadName = Thread.currentThread().getName();
                Integer connection = pool.acquireConnection(threadName);
                Thread.sleep(1000);
                pool.releaseConnection(threadName, connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        service.execute(task);

    }

}
