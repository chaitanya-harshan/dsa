package stacks_queues.neetcode.extras;

import java.util.Stack;

public class final_prices_with_special_disc_in_shop {
    
    /*
     * Thought Process:
     * 1. Problem Understanding:
     *    - For each item i, we need to find the first item j after i where prices[j] <= prices[i]
     *    - The final price for item i will be prices[i] - prices[j]
     *    - If no such j exists, no discount applies
     * 
     * 2. Solution Using Monotonic Stack:
     *    - Process array from right to left
     *    - Stack maintains potential discount values in increasing order
     *    - For each price, pop larger values (they can't be discounts)
     *    - Top of stack will be the next smaller or equal value (the discount)
     * 
     * 3. Example: [8,4,6,2,3]
     *    - Start from right: [8,4,6,2,3]
     *                                 ↑
     *    - Stack: [3]
     *    - Process 2: Stack: [2]  (3 popped as it's larger)
     *    - Process 6: Stack: [2,6]
     *    - Process 4: Stack: [2,4]  (6 popped as it's larger)
     *    - Process 8: Stack: [2,4,8]
     * 
     * Time: O(n), Space: O(n)
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i=n-1; i>=0; i--) {
            // Remove all prices that are too large to be discounts
            while (!st.empty() && st.peek() > prices[i]) {
                st.pop();
            }
            // If stack has a value, it's the discount. Otherwise, no discount
            if (!st.empty()) ans[i] = prices[i] - st.peek();
            else ans[i] = prices[i];
            // Add current price as potential discount for items to the left
            st.push(prices[i]);
        }
        return ans;
    }
}

/*
 * 1475. Final Prices With a Special Discount in a Shop
 * 
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * 
 * Given an array prices where prices[i] is the price of the ith item in a shop.
 * There is a special discount for items in the shop:
 * If you buy the ith item, then you will receive a discount equivalent to 
 * prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i].
 * If there is no j, you will not receive any discount at all.
 * 
 * Example:
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 * Explanation:
 * - For item 0: price = 8, first smaller/equal is 4, final price = 8-4 = 4
 * - For item 1: price = 4, first smaller/equal is 2, final price = 4-2 = 2
 * - For item 2: price = 6, first smaller/equal is 2, final price = 6-2 = 4
 * - For item 3: price = 2, no discount possible, final price = 2
 * - For item 4: price = 3, no discount possible, final price = 3
 */


