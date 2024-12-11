package dp.subsequences;

public class _11_rod_cutting_unbounded_knapsack {
    
    public static int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[] prev = new int[n+1];
        
        for (int i=n; i > 0; i--) {
            int[] dp = new int[n+1];
            dp[0] = 0;
            for (int k=0; k<=n; k++) {
                int taken = 0;
                if (k >= i) taken = price[i-1] + dp[k-i];
                int notTaken = prev[k];
                
                dp[k] = Math.max(taken, notTaken);
            }
            prev = dp;
        }
        
        return prev[n];
    }
}

/*
 * Given a rod of length n inches and an array of prices, price. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.
https://www.geeksforgeeks.org/problems/rod-cutting0840/1

Example:

Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5+17=22.
Input: price[] = [3, 5, 8, 9, 10, 17, 17, 20]
Output: 24
Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1]= 8*3 = 24.
Input: price[] = [1, 10, 3, 1, 3, 1, 5, 9]
Output: 40
 */




 public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int[][] dp = new int[n+2][n+1];
        
        for(int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for(int s = n; s > 0; s--) {
            for(int target = 1; target <= n; target++) {
                dp[s][target] = dp[s+1][target];
                if(s <= target) dp[s][target] = (dp[s][target] + dp[s][target-s]) % MOD;
            }
        }
        
        System.out.println(dp[1][n]);
        sc.close();
    }