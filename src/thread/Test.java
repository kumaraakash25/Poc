package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Test {
    static ExecutorService service = Executors.newFixedThreadPool(1);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        Future<Integer> future = service.submit(()->{
            System.out.println("Hello");
            return 1;
        });

        System.out.println(future.get());*/

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");
        System.out.println(future.get());

        List list = new ArrayList<>();

        list.stream().filter(e -> e.equals(10)).collect(Collectors.toList());




    }
}
