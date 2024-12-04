package dp.sde.1d;

public class _01_max_product_subArr {
    
    public int maxProduct(int[] nums) {
        double prefix = 1, suffix = 1;
        double maxP = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            prefix *= nums[i];
            suffix *= nums[n-1-i];
            maxP = Math.max(prefix, Math.max(suffix, maxP));

            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
        }
        return (int)maxP;
    }
}


/*
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * https://www.youtube.com/watch?v=Y6B-7ZctiW8&t=18s
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
 */