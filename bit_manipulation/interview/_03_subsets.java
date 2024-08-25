package bit_manipulation.interview;

import java.util.List;
import java.util.ArrayList;

public class _03_subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int subsets = 1 << nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int num = 0; num < subsets; num++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j<nums.length; j++) {
                if ((num & (1 << j)) > 0) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }

        return result;
    }
}

/*
https://leetcode.com/problems/subsets/description/

 * Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */