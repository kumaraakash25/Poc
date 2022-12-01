package thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(2); // This will engage 2 cores

        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20);
        long start =  System.currentTimeMillis();
        List<Integer> result = pool.submit(() -> testList.parallelStream().map(item -> item * 2).collect(Collectors.toList())).join();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }
}
