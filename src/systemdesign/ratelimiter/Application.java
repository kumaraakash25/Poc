package systemdesign.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    static ExecutorService executorService = Executors.newFixedThreadPool(12);

    public static void main(String[] args) throws InterruptedException {
        TokenBucket bucket = new TokenBucket(10, 10);
        for (int count = 0; count < 12; count++) {
            executorService.execute(() -> getToken(bucket));
        }
        executorService.shutdown();
    }

    private static void getToken(TokenBucket bucket) {
        if (bucket.grantAccess()) {
            System.out.println(Thread.currentThread().getName() + ">> Thread can access");
        } else {
            System.out.println(Thread.currentThread().getName() + ">> Cannot access");
        }
    }
}
