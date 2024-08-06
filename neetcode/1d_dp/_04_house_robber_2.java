/*
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/description/
 * 
 * ---circular houses robber
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police. 
 */

public class _04_house_robber_2 {
    
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robHouses(nums, 0, n-2), robHouses(nums, 1, n-1));
    }

    public static int robHouses(int[] houses, int start, int end) {
        int first = 0, second = 0;
        for (int i=start; i <= end; i++) {
            int temp = Math.max(first + houses[i], second);
            first = second;
            second = temp;
        }
        return second;
    }
}


