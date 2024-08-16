package recursion.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_print_unique_subsets {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrack(result, arr, 0, nums);
        return result;
    }

    static void backtrack(List<List<Integer>> result, List<Integer> arr, int k, int[] nums) {
        if (k == nums.length) {
            result.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[k]);
        backtrack(result, arr, k+1, nums);
        arr.removeLast();

        while (k+1 < nums.length && nums[k] == nums[k+1]) k++;
        backtrack(result, arr, k+1, nums);
    }
}

/*
 * 90. Subsets II
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Input: nums = [0]
Output: [[],[0]]
 */