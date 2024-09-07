package greedy.easy;

/**
 * __valid_paranthesis_extra
 */
public class __valid_paranthesis_extra {

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        int min = 0, max = 0;
        for (int i = 0; i<s.length(); i++) {
            if (locked.charAt(i) == '0') {
                min--;
                max++;
            }
            else {
                if (s.charAt(i) == '(') {
                    min++;
                    max++;
                }
                else {
                    min--;
                    max--;
                }
            }

            if (min < 0) min = 0;
            if (max < 0) return false;
        }
        return min == 0;

        // int close = 0, open = 0, flip = 0;
        // if (s.length() % 2 != 0) return false;
        // for (int i = 0; i<s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (c == '(' || locked.charAt(i) == '0') open++;
        //     else open--;
        //     if (open < 0) return false;
        // }
        // close = 0;
        // for (int i = s.length()-1; i >= 0; i--) {
        //     char c = s.charAt(i);
        //     if (c == ')' || locked.charAt(i) == '0') close++;
        //     else close--;
        //     if (close < 0) return false;
        // }
        // return true;
    }
}

/*
 * 2116. Check if a Parentheses String Can Be Valid
 * https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/
 * it's solved same as the other valid parenthesis problem ((*()*)) - greedy/easy_05
 

 
A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

If locked[i] is '1', you cannot change s[i].
But if locked[i] is '0', you can change s[i] to either '(' or ')'.
Return true if you can make s a valid parentheses string. Otherwise, return false.

Input: s = "))()))", locked = "010100"
Output: true
Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.

Input: s = "()()", locked = "0000"
Output: true
Explanation: We do not need to make any changes because s is already valid.

Input: s = ")", locked = "0"
Output: false
Explanation: locked permits us to change s[0]. 
Changing s[0] to either '(' or ')' will not make s valid.
 

Constraints:

n == s.length == locked.length
1 <= n <= 105
s[i] is either '(' or ')'.
locked[i] is either '0' or '1'.

 */