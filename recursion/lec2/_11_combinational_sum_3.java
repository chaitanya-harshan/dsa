package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class _11_combinational_sum_3 {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 1;
        backtrack(result, new ArrayList<>(), i, k, n);
        return result;        
    }

    static void backtrack(List<List<Integer>> result, List<Integer> list, int i, int k, int target) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (i > 9) return;
        
        if (i <= target && k > 0) {
            list.add(i);
            backtrack(result, list, i+1, k-1, target-i);
            list.removeLast();

            backtrack(result, list, i+1, k, target);
        }
        else return;
    }
}

/*
 * 216. Combination Sum III
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Input: k = 3, n = 7
Output: [[1,2,4]]

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
 */