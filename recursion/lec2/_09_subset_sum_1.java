/*
 * Given a list arr of n integers, return sums of all subsets in it. Output sums can be printed in any order.

Input:
n = 2    arr[] = {2, 3}
Output: 0 2 3 5

https://practice.geeksforgeeks.org/problems/subset-sums2234/1

 */
package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class _09_subset_sum_1 {
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> sums = new ArrayList<>();
        backtrack(sums, 0, 0, arr, n);
        return sums;
    }
    
    static void backtrack(List<Integer> sums, int k, int sum, List<Integer> arr, int n) {
        if (k == n) {
            sums.add(sum);
            return;
        }
        
        backtrack(sums, k+1, sum+arr.get(k), arr, n);
        backtrack(sums, k+1, sum, arr, n);
    }
}
