package dp.strings;

public class _06_do_ops_to_make_strings_same {
    
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] prev = new int[m+1];

        for (int i=1; i<=n; i++) {
            int[] dp = new int[m+1];

            for (int j=1; j<=m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) dp[j] = 1 + prev[j-1];
                else dp[j] = Math.max(dp[j-1], prev[j]);
            }
            prev = dp;
        }

        int LCS = prev[m];
        System.out.println(LCS+" "+n+" "+m);
        return n-LCS + m-LCS;
    }
}

/*
 * 583. Delete Operation for Two Strings
https://leetcode.com/problems/delete-operation-for-two-strings/description/

Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
 */