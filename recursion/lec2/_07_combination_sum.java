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
 */
package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class _07_combination_sum {

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        List<List<Integer>> list = generateCombinationSum(nums, 7);
        for (List<Integer> inner : list) {
            System.out.println(inner);
        }
        
    }

    public static List<List<Integer>> generateCombinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generate(result, new ArrayList<>(), 0, target, nums);
        return result;
    }
    
    
    public static void generate(List<List<Integer>> result, List<Integer> list, int i, int target, int[] nums) {
        // if we find the sum (target becomes 0) then we dont need to do further recursion calls in that particual tree track
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (i == nums.length) return;
        // if (i == nums.length) {
        //     if (target == 0) {
        //         result.add(new ArrayList<>(list));
        //     }
        //     return;
        // }
        
        if (nums[i] <= target) {
            list.add(nums[i]);
            generate(result, list, i, target-nums[i], nums);
            list.removeLast();
        }

        generate(result, list, i+1, target, nums);
    }
}
