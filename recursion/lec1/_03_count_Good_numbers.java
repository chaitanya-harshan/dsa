package recursion.lec1;

public class _03_count_Good_numbers {

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(222));
    }
    
    static final long MOD = 1000000007; // 10^9 + 7

    public static int countGoodNumbers(long n) {
        long ans = pow(5, (n+1)/2) * pow(4, n/2) % MOD;
        return (int)ans;
    }

    private static long pow(long base, long exp) {
        base = base % MOD;
        if (exp == 0) return 1;
        if (exp == 1) return base;
        if (exp % 2 == 1) return base * pow(base, exp-1) % MOD;
        else {
            // long bro = base * base % MOD;
            // return pow(bro, exp/2) % MOD;
            return pow(base * base, exp/2) % MOD; 
        } 
    }
}

/*
 * 1922. Count Good Numbers

A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303
 */