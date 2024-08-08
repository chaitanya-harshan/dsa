/*
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 
Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

322. Coin Change
https://leetcode.com/problems/coin-change/description/
 */
import java.util.Arrays;

public class _08_coins_change_2 {

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        System.out.println(coinChange(coins, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1; i <= amount; i++) {
            int MinCoins = amount+1; // or INT MAX
            for (int j=0; j<coins.length; j++) {
                if (coins[j] <= i) {
                    MinCoins = Math.min(MinCoins, 1 + dp[i-coins[j]] );
                     // all the 0,1...,n-1 values are processed before comming to i=n
                }
            }
            dp[i] = MinCoins; // becomes amount+1 if dp[i] can't be found/processed
        }
        return dp[amount] != amount +1 ? dp[amount] : -1;
    }
    // every amount from 0 - amount is evaluated even if some of the nums<amount are not possible.
    // If amount 'i' can't be found then then dp[i]/Mincoins = (amount+1){max value}
    // If you're wondering how will it take repeat coins of the same coin.. consider 1st example
    // you will see that 7 already contains a 5 coin and you use a 5 & {7 coin} for getting 12.

    /* consider for better understanding:
     [3,4,5] , 12 --> dp[12-5] = dp[7] = dp[7-4] = dp[3] = 1
     
     [2,4] , 7 --> dp[7-4] = dp[3] = dp[3-2] = dp[1] = XX no solution
     0   1   2   3   4   5   6   7
               1+[1]   1+[1]   1+[3]
     0   8   1 (1+8) 1 (1+8) 2 (1+8)
    */
    


    // Greedy Algo --- WON'T WORK cause if coins[a,b,c,d] --> 2a !< b || 2b !< c & so on
    public static int coinChangeGreedy(int[] coins, int amount) {
        Arrays.sort(coins);
        int idx = coins.length-1;
        int count = 0;
        // for (int i = idx-1; i>=0; i--) {
        while (amount != 0) {
            if (amount >= coins[idx]) {
                amount -= coins[idx];
                count++;
            }
            else if (idx != 0) idx--;
            else return -1;
        }
        return count;
    }
}

