/*
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Input: x = 2.10000, n = 3
Output: 9.26100

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


 */
package recursion.lec1;

public class _02_pow {
    
    public static double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        if (n < 0) return 1.0 / (x*myPow(x, -1*(n+1)) ); // int_min is -2^31 but int_max is 2^31-1 
        // so we reduce the number in case it's int_min

        if (n % 2 == 1) return x*myPow(x, n-1);
        else return myPow(x*x, n/2);
    }
}
