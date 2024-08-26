package recursion.sde;

import java.util.ArrayList;
import java.util.List;

public class _01_print_all_permutations_array {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, result);
        return result;
    }

    static void backtrack(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i: nums) ds.add(i);
            result.add(ds);
            return;
        }

        for (int i=index; i<nums.length; i++) {
            swap(nums, index, i);
            backtrack(index+1, nums, result);
            swap(nums, index, i);
        }
    }

    static void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//                                           [123]
//        1[123]                        2-swap(0,1)[213]               3-swap(0,2)[312]
//  2[123]    3-swap(1,2)[132]      1[213]   3-swap(1,2)[231]      1[312]     2-swap(1,2)[321]



/*
https://leetcode.com/problems/permutations/description/
 * 6. Permutations
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
 */