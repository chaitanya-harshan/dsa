package dp.1D;

public class _03_frog_jump_with_k_possible_jumps {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        
        for (int i=n-2; i>=0; i--) {
            int cur = Integer.MAX_VALUE;
            
            for (int j=1; j<k+1; j++) {
                if (i+j >= n) break;
                int jump = Math.abs(arr[i]-arr[i+j]) + dp[i+j];
                cur = Math.min(jump, cur);
            }
            dp[i] = cur;
        }
        return dp[0];
    }
}

/*
 * https://www.geeksforgeeks.org/problems/minimal-cost/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimal-cost
 * GFG
 * Minimal Cost
 * There is an array arr of heights of stone and Geek is standing at the first stone and can jump to one of the following: Stone i+1, i+2, ... i+k stone, where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches the last stone.

Example:

Input: k = 3, arr[]= [10, 30, 40, 50, 20]
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30, which is minimum
 */