public class DuplicateNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -8, 2, 1, 4};
        int num =0;
        for (int A: arr) {
            num = num ^ A;
        }
        System.out.println(num);
    }
}

/**
 *  01
 *  10
 *  11 = 3
 */