public class AdjacentShifts {

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 0, 1, 0, 1, 1};
        int leftPointer = 0;
        int rightPointer = arr.length;
        while (leftPointer <= rightPointer) {
            if (arr[leftPointer] == 0) {
                leftPointer ++;
            }
            if (arr[rightPointer] == 1) {
                rightPointer --;
            }


        }
    }
}
