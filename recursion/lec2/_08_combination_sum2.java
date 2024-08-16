/*
 * 40. Combination Sum II
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[[1,1,6],
[1,2,5],
[1,7],
[2,6]]

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[[1,2,2],
[5]]

https://leetcode.com/problems/combination-sum-ii/description/
 */
package recursion.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _08_combination_sum2 {

    public static void main(String[] args) {
        int target;
        // int[] nums = {1,2,3};
        // int[] nums = {10,1,2,7,6,1,5}; target = 8;
        // int[] nums = {2,5,2,1,2}; target = 5;//
        int[] nums = {1,1,1,2,2}; target = 4; 
        List<List<Integer>> list = new ArrayList<>();
        list = combinationSum2(nums, target);

        // for (List<Integer> inner : list) {
        //     System.out.println(inner);
        // }
        // System.out.println("size "+list.size());
        System.out.println(list);
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        // generate(result, new ArrayList<>(), 0, target, candidates);
        backtrack2(result, new ArrayList<>(), 0, target, candidates);
        return result;
    }

    static void generate(List<List<Integer>> result, List<Integer> list, int i, int target, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (i == candidates.length) return;

        if (candidates[i] <= target) {
            list.add(candidates[i]);
            generate(result, list, i+1, target-candidates[i], candidates);
            list.removeLast();
        }

        while (i+1 < candidates.length && candidates[i+1] == candidates[i]) i++;
        generate(result, list, i+1, target, candidates);
    }

    static void backtrack2(List<List<Integer>> result, List<Integer> list, int k, int target, int[] nums) {
        // System.out.println(target +", "+list);
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = k; i < nums.length; i++) {
            if (i > k && nums[i] == nums[i-1]) continue;
            if (nums[k] > target) break;

            list.add(nums[k]);
            // System.out.println(i+","+target+"-"+nums[k]+" "+list+"~~~~~~~~~~~~~~~~~`");
            backtrack2(result, list, i+1, target-nums[i], nums);
            list.removeLast();
        }
    }
}
