/*
* Given an array arr of size n of non-negative integers and an integer sum, the 
task is to count all subsets of the given array with a sum equal to a given sum.
Note: Answer can be very large, so, output answer modulo 109+7.

Examples:

Input: n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
Output: 3
Explanation: {5, 2, 3}, {2, 8}, {10} are possible subsets.

Input: n = 5, arr = [2, 5, 1, 4, 3], sum = 10
Output: 3
Explanation: {2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.
*/
package dp.subsequences;

import java.util.Arrays;

public class _04_number_of_subsets_sum_k {
    public static void main(String[] args) {
        int[] nums = {5,2,3,10,6,8};
        int sum = 10;
        // System.out.println(subsetsWithSumK(nums, sum));
        // System.out.println(perfectSum(nums, nums.length, sum));
        System.out.println(perfectSum(new int[]{1,0}, 2, 1));
    }
    
    public static int perfectSum(int nums[],int n, int sum)	{ 
	    int[][] dp = new int[n][sum+1];
	    dp[n-1][0] = 1;
	    if (nums[n-1] <= sum) dp[n-1][nums[n-1]] = 1;
	    
	    for (int idx=n-2; idx>=0; idx--) {
	        for (int k=0; k<=sum; k++) {
	            int notTaken = dp[idx+1][k];
	            int taken = 0;
	            if (nums[idx] <= k) {
	                taken = dp[idx+1][k-nums[idx]];
	            }
	            
	            dp[idx][k] = notTaken + taken;
	        }
	    }
        System.out.println(Arrays.deepToString(dp));
	    return dp[0][sum];
	}


    
    // ********* Recursion **********
    final static int MOD = (int)(Math.pow(10, 9) + 7);

    static int subsetsWithSumK1(int[] nums, int sum) {
        int cnt = backtrack(0, sum, nums, nums.length);
        return cnt % MOD;
    }
    static int backtrack(int i, int k, int[] nums, int n) {
        // if (k == 0) return 1; // cause u also have '0's in the array so [5] & [5,0] count as 2 subsets
        if (k < 0) return 0;
        if (i == n ) {
            if ( k == 0) return 1;
            else return 0;
        }
        int left = backtrack(i+1, k-nums[i], nums, n);
        int right = backtrack(i+1, k, nums, n);
        return (left + right) % MOD;
    }
}
