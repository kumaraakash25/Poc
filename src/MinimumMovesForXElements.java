import java.util.HashMap;
import java.util.Map;

public class MinimumMovesForXElements {
    public static void main(String[] args) {
        //int[] data = {1, 2, 2, 2, 5, 5, 5, 8};
        int[] data = {1, 1, 3, 4, 4, 4};
        findMinMoves(data);
    }

    private static void findMinMoves(int[] data) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (dataMap.containsKey(data[i])) {
                dataMap.put(data[i], dataMap.get(data[i]) + 1);
            } else {
                dataMap.put(data[i], 1);
            }
        }
        int[] minOperations = {0};
        dataMap.forEach((digit, occurrence) -> {
            if (digit != occurrence) {
                if (digit < occurrence) {
                    minOperations[0] += (occurrence - digit);
                } else if (digit > occurrence) {
                    minOperations[0] += Math.min(Math.abs(occurrence - digit), occurrence);
                } else {
                    minOperations[0] += occurrence;
                }
            }
        });
        System.out.println("Minimum occurrences" + minOperations[0]);
    }
}
