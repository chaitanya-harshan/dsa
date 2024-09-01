package bit_manipulation.interview;

public class _04_xor_in_range {
    
    public static int findXOR(int l, int r) {
        // if (l == r) return 0;
        
        // int xor = l;
        // for (int i = l+1; i<=r; i++) {
        //     xor ^= i;
        // }
        // return xor;
        
        return xor(l-1) ^ xor(r);
    }
    
    static int xor(int n) {
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n+1;
        if (n % 4 == 3) return 0;
        else return n; // (n % 4 == 0) 
    }
}

// https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-xor-of-numbers-from-l-to-r
// O(n) = 1

/*
1 -                         1
2 - 1^2 =                   3
3 - 1^2^3 =                 0
4 - 1^2^3^4 =               4

5   1^2^3^4^5 =             1
6 - 1^2^3^4^5^6 =           7
7 - 1^2^3^4^5^6^7 =         0
8 - 1^2^3^4^5^6^7^8 =       8

9 -                         1
10 -                        11

 */

/*
 * You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].

Example:

Input: 
L = 4, R = 8 
Output:
8 
Explanation:
4 ^ 5 ^ 6 ^ 7 ^ 8 = 8
 */