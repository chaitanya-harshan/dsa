/**
 * Given a number n and a bit number k, check if kth index bit of n is set or not. A bit is called set if it is 1. Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number.
Note: Index is starting from 0. 

Input: n = 4, k = 2
Output: Yes
Explanation: Binary representation of 4 is 100,

https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1
 */

package bit_manipulation.easy;

public class _02_check_kth_bit {

    public static void main(String[] args) {
        System.out.println(checkKthBit(10, 3));
    }

    static boolean checkKthBit(int n, int k) {
        n = n >> k;
        return (n & 1) == 1;
    }
}