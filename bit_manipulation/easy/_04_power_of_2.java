// 8     00001000
// 8-1   00000111

// 8 & 8-1  --> 0          [0&0 = 0,  1&1 = 1 and rest 0]

// 10     1010
// 10-1   1001

// & --> 0100 which is != 0

public class _04_power_of_2 {
    
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & n-1) == 0;
    }
}

/*
 * https://leetcode.com/problems/power-of-two/
 * 
 * 231. Power of Two
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

 
 */