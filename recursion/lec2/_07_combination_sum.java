/*
 * 39. Combination Sum
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []

https://leetcode.com/problems/combination-sum/
https://youtu.be/GBKI9VSKdGg - neetcode
 */
package recursion.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _07_combination_sum {

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        List<List<Integer>> list = combinationSum(nums, 7);
        System.out.println(list);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    static void backtrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int k, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (k == candidates.length) return;

        // if (target > 0) {
        //     list.add(candidates[k]);
        //     backtrack(res, list, candidates, k, target-candidates[k]);
        //     list.removeLast();

        //     backtrack(res, list, candidates, k+1, target);
        // }

        if (candidates[k] <= target) {
            list.add(candidates[k]);
            backtrack(res, list, candidates, k, target-candidates[k]);
            list.removeLast();
        }

        backtrack(res, list, candidates, k+1, target);
    }
}

// it's a binary => take it(the current index num) or skip(dont add the curr num) and go to next index
/*
                                  abcd

                                   [],0
                 [a],0                                 [],1
      [aa],0              [a],1              [b],1               [],2
[aaa],0  [aa],1       [ab],1  [a],2      [bb],1  [b],2        [c],2  [],3 
.
.
. continue
if by adding nums[i] to sum, sum exceeds target then we return
*/

