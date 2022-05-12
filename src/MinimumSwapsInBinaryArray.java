public class MinimumSwapsInBinaryArray {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 0, 1};
        int length = arr.length;

        int count = 0;
        int misplacedZeroes = 0;
        for (int index = length - 1; index >= 0; index--) {
            if (arr[index] == 0) {
                misplacedZeroes += 1;
            } else {
                count += misplacedZeroes;
            }
        }
        System.out.println(count);
    }
}
