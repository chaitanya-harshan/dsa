package dp.strings;

public class _04_longest_plaindrome_substring {
    
    // just revese rhe string as s2 and do LCS b/w 's' and 's.reverse'
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[] prev = new int[n+1];

        for (int i=1; i<=n; i++) {
            int[] dp = new int[n+1];
            dp[0] = 0;//
            
            for (int j=1; j<=n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) dp[j] = 1 + prev[j-1];
                else {
                    //  left - (i, j-1), right - (i-1, j)
                    dp[j] = Math.max(dp[j-1], prev[j]);
                }
            }
            prev = dp;
        }
        return prev[n];
    }
}

/*
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 * 
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
 */