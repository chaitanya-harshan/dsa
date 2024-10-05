package dp.subsequences;

public class _01_subset_sum_k {
    // almost similar without the first row - https://youtu.be/34l1kTIQCIA

    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k+1];

        for (boolean[] row : dp) {
            row[0] = true;
        }
        if (arr[0] <= k) dp[0][arr[0]] = true;

        for (int idx = 1; idx < n; idx++) {
            for (int target = 1; target <= k; target++) {

                boolean notTaken = dp[idx-1][target];
                boolean taken = false;
                if (notTaken == false && arr[idx] <= target) {
                    taken = dp[idx-1][target-arr[idx]];
                }

                dp[idx][target] = notTaken || taken;

                if (dp[idx][k] == true) return true;
            }
        }

        return dp[n-1][k];
    }
}

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