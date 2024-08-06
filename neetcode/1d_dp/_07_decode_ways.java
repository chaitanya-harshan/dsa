/*
 * https://leetcode.com/problems/decode-ways/description/
 * 
 * Given a string s containing only digits, return the number of ways to decode it.
 * If the entire string cannot be decoded in any valid way, return 0.
The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1: Input: s = "12"
Output: 2

Explanation:"12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation:"226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "06"
Output: 0
Explanation:"06" cannot be mapped to "F" because of the leading zero ("6" is different from "06"). In this case, the string is not a valid encoding, so return 0.
 */



// used bottom up recursion 
//  Eg: 1
    //  1    2    1   3  1
    // 3+2  2+1  1+1  1  1
    //  5    3    2   1  1

// Eg: 2
    //  1    1    1   0  6
    // 1+1  1+0  0+1  0  1
    //  2    1    1   0  1
    
public class _07_decode_ways {
    
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }

    public static int numDecodings(String s) {
        int one = 1, two = 0;
        for (int i = s.length()-1; i>=0; i--) {

            if (s.charAt(i) != '0') {
                int temp = 1;
                if (i < s.length()-1) {
                    int num = (s.charAt(i)-'0') * 10 + (s.charAt(i+1)-'0');
                    if (num <= 26) temp = one + two;
                    else temp = one;
                }
                two = one;
                one = temp;
            }
            else {
                two = one;
                one = 0;
            }
        }
        return one;
    }
}
