package microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        int number = 6;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i< arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i=0; i< arr.length; i++) {
            int expectedNumber = number - arr[i];
            if(set.contains(expectedNumber)) {
                System.out.println("Found");
                System.exit(0);
            }
        }

    }
}
