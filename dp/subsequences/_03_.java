package dp.subsequences;

import java.util.Arrays;

public class _03_ {
    public static void main(String[] args) {
        // int[] nums = {3,9,7,3};
        // int[] nums = {-36,36};
        int[] nums = {1,2,10,1,9,10,5};
        System.out.println(minimumDifference(nums));
    }

























    public static int minimumDifference1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int len = nums.length;
        int[][] dp = new int[len][sum+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MIN_VALUE));

        return helper(0, len/2, 0, nums, sum, dp);
    }
    static int helper(int i, int n, int k, int[] nums, int sum, int[][] dp) {
        if (n == 0) return Math.abs(sum - 2*k);
        if (i == nums.length) return Integer.MAX_VALUE;
        if (dp[i][k] != Integer.MIN_VALUE) return dp[i][k];

        int a = helper(i+1, n-1, k+nums[i], nums, sum, dp);
        int b = helper(i+1, n, k, nums, sum, dp);
        return dp[i][k] = Math.min(a,b);
    }
}
