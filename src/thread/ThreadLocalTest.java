package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    private static ExecutorService service = Executors.newFixedThreadPool(5);


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> new TLocal());
        t1.start();


    }
}

class TLocal implements Runnable {
    public ThreadLocal<Integer> getThreadLocal() {
        return threadLocal;
    }

    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    int max = 10;
    int min = 1;

    @Override
    public void run() {
        int random = min + (max - min) * (int) Math.random();
        threadLocal.set(random);
    }
}
