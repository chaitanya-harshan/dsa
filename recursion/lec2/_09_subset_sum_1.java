/*
 * Given a list arr of n integers, return sums of all subsets in it. Output sums can be printed in any order.

Input:
n = 2    arr[] = {2, 3}
Output: 0 2 3 5
 */
package recursion.lec2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _09_subset_sum_1 {
    
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        Collections.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        generateSums(list, 0, arr, 0, n);
        return list;
    }
    
    static void generateSums(List<Integer> list, int i, List<Integer> arr, int sum, int n) {
        if (i == n) {
            list.add(sum);
            return;
        }
        
        generateSums(list, i+1, arr, sum+arr.get(i), n);
        generateSums(list, i+1, arr, sum, n);
    }
}
