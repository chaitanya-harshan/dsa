package arrays.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * union
 */
public class union_of_arrays {

    public static void main(String[] args) {
            int[] arr1 = {1,2,3,4,5};
            int[] arr2 = {2,2,3,6,4,5};
            System.out.println(Arrays.toString(union(arr1,arr2)));
        }
        
    static int[] union(int[] arr1, int[] arr2) {
        HashSet<Integer> freq = new HashSet<>();
        // ArrayList<Integer> union = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if (!freq.contains(arr1[i])) {
                freq.add(arr1[i]);
            }
        }
        for (int j = 0; j < arr2.length; j++) {
            if (!freq.contains(arr2[j])) {
                freq.add(arr2[j]);
            }
        }

        int[] unionArr = new int[freq.size()];
        int i = 0;
        for ( int key: freq) { // freq.keySet() for HashMap
            unionArr[i] = key;
            i++;
        }
        return unionArr;
    }
}