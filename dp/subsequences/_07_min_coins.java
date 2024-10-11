package dp.subsequences;

import java.util.Arrays;

public class _07_min_coins {
    
    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(coinChange(coins, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        // sorting the coins[] - (better) as coins len is max 12
        Arrays.sort(coins);
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        for (int k=1; k <= amount; k++) {
            int minCoins = amount+1; // don't use Int.MAX becasue it will overflow when u do 1+dp[]
            for (int i=0; i<coins.length; i++) {
                if (coins[i] <= k) {
                    minCoins = Math.min(minCoins, 1 + dp[k-coins[i]] );
                }
                if (coins[i] > amount) break;
            }
            dp[k] = minCoins;
        }
        return dp[amount] != amount+1 ? dp[amount] : -1;

        // without sorting the coins array 
        // int[] dp = new int[amount + 1];
        // dp[0] = 0;
        // for (int k=1; k <= amount; k++) {
        //     int MinCoins = amount+1; // don't use Int.MAX becasue it will overflow when u do 1+dp[]
        //     for (int i=0; i<coins.length; i++) {
        //         if (coins[i] <= k) {
        //             MinCoins = Math.min(MinCoins, 1 + dp[k-coins[i]] );
        //              // only if the all the 0,1...,n-1 values are processed then it comes to i=n
        //         }
        //     }
        //     dp[i] = MinCoins;
        // }
        // return dp[amount] != amount +1 ? dp[amount] : -1;
    }
    // every amount from 0 - amount is evaluated even if some of the nums<amount are not possible.
    // If amount 'i' can't be found then then dp[i]/Mincoins = (amount+1){max value}

    /* consider for better understanding:
     [3,4,5] , 12 --> dp[12-5] = dp[7] = dp[7-4] = dp[3] = 1
     
     [2,4] , 7 --> dp[7-4] = dp[3] = dp[3-2] = dp[1] = XX no solution
     0   1   2   3   4   5   6   7
               1+[1]   1+[1]   1+[3]
     0   8   1 (1+8) 1 (1+8) 2 (1+8)
    */
}
