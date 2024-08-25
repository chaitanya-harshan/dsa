package bit_manipulation.interview;

public class _02_num_appears_odd_times_in_array {
    public int singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i=1; i<nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}

/*
 * 136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
 */