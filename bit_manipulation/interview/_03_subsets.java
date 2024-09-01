package bit_manipulation.interview;

import java.util.ArrayList;
import java.util.List;

public class _03_subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int subsets = 1 << nums.length; // eg: [1,2,3] u have to iterate from 0 to 2^3
        // check for set bits in that num and add the corresponding values of nums[] to list, therby using the bits are reference for the index
        List<List<Integer>> result = new ArrayList<>();

        for (int num = 0; num < subsets; num++) {
            List<Integer> list = new ArrayList<>();
            // checking if bits of "num" are set. Then that index val of nums[] is appended to list 
            for (int j = 0; j<nums.length; j++) {
                // checking condition for if bit is set.
                // checks for > because num & 1<<j is not always 1. if j > 0 then you'll get more than 1.
                // But since u know it's set if it's > 0 thats why u only check for > 0
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
https://youtu.be/h4zNvA4lbtc
https://leetcode.com/problems/subsets/description/

 * Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */