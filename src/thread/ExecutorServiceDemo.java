package thread;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<Integer>> results = service.invokeAll((
                IntStream.range(1,100_00)
                        .mapToObj(RunnableThread::new)
                        .collect(Collectors.toList())));
        service.shutdown();
    }
}

class RunnableThread implements Callable<Integer> {

    int number;
    public RunnableThread(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread" + number);
        return number;
    }
}

