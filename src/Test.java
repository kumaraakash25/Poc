import java.util.*;
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.push(num);
        }
        int[] arr = new int[m];
        int maxUnique = 0;


        while(deque.size()> 0) {

            Set<Integer> set = new HashSet<>();
            arr[0] = (int) deque.removeLast();
            set.add(arr[0]);
            for (int i =1; i<m ; i++) {
                arr[i] = (int) deque.getLast();
                set.add(arr[i]);
            }
            if (set.size() > maxUnique) {
                maxUnique = set.size();
            }
        }
        System.out.print(maxUnique);
    }
}

