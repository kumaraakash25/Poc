import java.util.HashMap;
import java.util.Map;

public class MyAlgo {

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 2, 2, 3, 4, 2};
        move(arr, 2);
        System.out.println(arr);
    }

    private static int[] move(int[] arr, int num) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int counter = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == num) continue;
            int iterations = entry.getValue();
            for (int i = 0; i < iterations; i++) {
                arr[++counter] = entry.getKey();
            }
        }
        while (counter < arr.length - 1) {
            arr[++counter] = num;
        }
        return arr;
    }
}
