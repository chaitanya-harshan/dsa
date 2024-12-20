package arrays.extras;

public class non_decreasing_array {

    public boolean checkPossibility(int[] nums) {
        // Keep track of how many modifications we've made
        int flag = 0;
        for (int i=1; i<nums.length; i++) {
            // If current number is greater than or equal to previous number,
            // the sequence is already non-decreasing at this point
            if (nums[i-1] <= nums[i]) continue;

            // If we find a decreasing pair (nums[i-1] > nums[i])
            if (flag == 0) {  
                // Two cases where we modify nums[i-1]:
                // 1. If we're at the start of array (i == 1)
                // 2. If changing the previous number doesn't break the sequence
                //    with the number before it (nums[i] >= nums[i-2])
                if (i == 1 || nums[i] >= nums[i-2])
                    nums[i-1] = nums[i];    // Lower the previous number
                else
                    nums[i] = nums[i-1];    // Raise the current number
                
                flag++; 
            }
            else return false;
        }
        return true;
    }
}

/*
 * Key Insight:
 * When we find a decreasing pair (nums[i-1] > nums[i]), we have two choices:
 * 1. Lower nums[i-1] to match nums[i]
 * 2. Raise nums[i] to match nums[i-1]
 * 
 * We choose option 1 (lower nums[i-1]) when:
 * - We're at the start of array (i == 1), or
 * - Lowering nums[i-1] won't break the sequence with nums[i-2]
 * 
 * Otherwise, we choose option 2 (raise nums[i])
 * 
 * Example walkthrough:
 * [4,2,3]
 * - Find decreasing pair 4 > 2
 * - At start of array, so lower 4 to 2
 * - Array becomes [2,2,3] which is non-decreasing
 * 
 * [4,2,1]
 * - Find decreasing pair 4 > 2
 * - Lower 4 to 2
 * - Array becomes [2,2,1]
 * - Find another decreasing pair 2 > 1
 * - Need second modification, return false
 */

 
// Eg1: 1 2 4 6 5, 6 7 8  -> 5 > 4 so we just need to  Red{6} to 5
// Eg2: 1 2 4 6 3, 6 7 8  -> 3 < 4 so we need to Inc{3} to 6
// Eg1, Eg2 will ret True

/*
 * 665. Non-decreasing Array
 * https://leetcode.com/problems/non-decreasing-array/description/
 * 
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You cannot get a non-decreasing array by modifying at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
 */