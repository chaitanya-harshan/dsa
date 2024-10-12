package dp.subsequences;

public class _09_coin_change_2__no_of_ways_ {
    
    // it's basically a number of subsets which can form amount k
    // tabulation - space optimized 
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int k=1; k<= amount; k++) {
            if (k % coins[n-1] == 0) dp[k] = 1;
        }

        for (int i = n-2; i >= 0; i--) {
            int[] temp = new int[amount+1];
            temp[0] = 1;
            for (int k=1; k<= amount; k++) {
                int notTaken = dp[k];
                int taken = 0;
                if (coins[i] <= k) {
                    taken = temp[k-coins[i]];
                }

                temp[k] = notTaken + taken;
            }
            dp = temp;
        }
        return dp[amount];
    }
}


/*
 * 518. Coin Change II
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
Input: amount = 10, coins = [10]
Output: 1
 

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
 */