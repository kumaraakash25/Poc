public class SelectionSort {

    private static void sort(int[] arr) {

        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j; // 1 2 4
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        sort(arr);
        System.out.println(arr);
    }
}
