package arrays.medium;

public class stocks {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < prices[buy]) {
                buy = i;
            }
            int profit = prices[i] - prices[buy];
            if (profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }

    /*
    
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
    buying and selling the stock multiple times
    
    Input: prices = [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    Total profit is 4 + 3 = 7.
    */
    public int maxProfit1(int[] prices) {
        int buy = 0;
        int maxPro = 0;
        int totalProfit = 0;
        for (int i = 0; i< prices.length; i++) {
            if (prices[i] < prices[buy]) 
                buy = i;
            int profit = prices[i] - prices[buy];
            if (profit > maxPro) 
                maxPro = profit;
            if (profit < maxPro) {
                totalProfit += maxPro;
                maxPro = 0;
                buy = i;
            }
        }
        return totalProfit + maxPro;
    }
}
