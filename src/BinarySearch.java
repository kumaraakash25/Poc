import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr= {2,1,5,4,3,8};
        Arrays.sort(arr);

        System.out.println(arr);
        int lementindex = findElement(3, arr, 0, arr.length);
        System.out.println(lementindex);

    }

    private static int findElement(int element, int[] array, int left, int right){
        if(left> right) {
            return -1;
        }
        int middle = (left + right)/2;
        if(array[middle] == element) {
            return middle;
        } else if (array[middle] > element) {
            // Searhc in the first half
            return findElement(element, array, left, middle-1);
        } else {
            return findElement(element, array, middle+ 1, right);
        }
    }
}
