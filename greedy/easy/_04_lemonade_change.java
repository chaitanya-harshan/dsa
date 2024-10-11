/*
 * At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from 
 * you and order one at a time (in the order specified by bills). Each customer will only buy one 
 * lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

Note that you do not have any change in hand at first.

Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.

Example 1:

Input: bills = [5,5,5,10,20]
Output: true
 */
package greedy.easy;

public class _04_lemonade_change {
    
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int i=0; i<bills.length; i++) {
            if (bills[i] == 5) five++;
            else if (bills[i] == 10) {
                ten++;
                if (five > 0) five--;
                else return false;
            }
            else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                    twenty++;
                }
                else if (ten == 0 && five >= 3) {
                    five = five - 3;
                    twenty++;
                }
                else return false;
            }
        }
        return true;
    }
}
