package dp.subsequences;

import java.util.HashSet;

public class _01_is_subset_sum_k {
    
    public static void main(String[] args) {
        System.out.println(isSubsetSum(6, new int[]{3,34,4,12,5,2}, 30));
    }

    public static Boolean isSubsetSum(int N, int arr[], int sum) {
        boolean dp[][] = new boolean[N][sum+1];
        dp[N-1][0] = true;
        for (int i=1; i<= sum; i++) {
            dp[N-1][i] = (arr[N-1] == i) ? true : false;
            if (arr[N-1] < i) break;
        }

        for (int idx = N-2; idx >= 0; idx--) {
            for (int k = 0; k <= sum; k++) {
                if (arr[idx] == k || dp[idx+1][k] == true) dp[idx][k] = true;
                else if (arr[idx] < k) {
                    // if (dp[idx+1][k-arr[idx]] == true) 
                    //     dp[idx][k] = true;
                    // else dp[idx][k] = false;
                    dp[idx][k] = dp[idx+1][k-arr[idx]]; 
                }
            }
        }
        return dp[0][sum];
    }

    // Input: n = 6, arr[] = {3, 34, 4, 12, 5, 2}, sum = 9

    //          _0_1_2_3_4_5_6_7_8_9_
    //   3  |    . x . . . . . . x [.]
    //  34  |    . x . x . x . x x .
    //   4  |    . x . x . x . x x .
    //  12  |    . x . x x . x . x x
    //   5  |    . x . x x . x . x x
    //   2  |    . x . x x x x x x x


/*
https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

    * You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 5
1 <= N <= 10^3
0 <= ARR[i] <= 10^9
0 <= K <= 10^3

    */

    // **************** MUCH SIMPLER PROCESS ***********
    public static Boolean isSubsetSum2(int N, int arr[], int sum) {    
        int target = sum;
        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int i = 0; i < arr.length; i++) {
            HashSet<Integer> tempdp = new HashSet<>(dp);
            for (Integer it : tempdp) {
                if (it + arr[i] == target) return true; 
                dp.add(it + arr[i]);
            }
        }
        return false;
    }

    // same process as above but did differently
    // almost similar in the video without the first row - https://youtu.be/34l1kTIQCIA
    // public static boolean subsetSumToK(int n, int k, int arr[]){
    //     boolean[][] dp = new boolean[n][k+1];

    //     for (boolean[] row : dp) {
    //         row[0] = true;
    //     }
    //     if (arr[0] <= k) dp[0][arr[0]] = true;

    //     for (int idx = 1; idx < n; idx++) {
    //         for (int target = 1; target <= k; target++) {

    //             boolean notTaken = dp[idx-1][target];
    //             boolean taken = false;
    //             if (notTaken == false && arr[idx] <= target) {
    //                 taken = dp[idx-1][target-arr[idx]];
    //             }

    //             dp[idx][target] = notTaken || taken;

    //             if (dp[idx][k] == true) return true;
    //         }
    //     }

    //     return dp[n-1][k];
    // }
}