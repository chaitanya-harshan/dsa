package dp.strings;

public class _05_min_insertions_to_make_plaindrome {
    // do - (LPS) Longest Palindrome Sub Sequence b/w 's' & 's.reverse'
    // then ---> n-LPS
    
    public int minInsertions(String s) {
        int n = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int[] prev = new int[n+1];

        for (int i=1; i<=n; i++) {
            int[] dp = new int[n+1];

            for (int j=1; j<=n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) dp[j] = 1 + prev[j-1];
                else dp[j] = Math.max(dp[j-1], prev[j]);
            }
            prev = dp;
        }
        int longestPalindromeSubseq = prev[n];
        return n - longestPalindromeSubseq;
    }
}

/*
 * 1312. Minimum Insertion Steps to Make a String Palindrome
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
 * 
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */