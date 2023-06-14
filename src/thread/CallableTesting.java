package thread;

import java.util.concurrent.*;

public class CallableTesting {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> fResult = service.submit(new CallableDemo());
        // This is wait because Future is blocking
        System.out.println("######Start######");
        System.out.println(fResult.get());
        System.out.println("#####End####");


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        }).thenApply(result -> {
            System.out.println(result);
            return "Result of the then apply";
        });

        System.out.println("End");

    }
}

class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Test String";
    }
}

