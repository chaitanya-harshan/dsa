package dp.strings;

public class _03_longest_common_substring {
    
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m+1];
        int max = 0;
        
        for (int i=1; i<=n; i++) {
            int[] dp = new int[m+1];
            // dp[0] = 0;
            for (int j=1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) dp[j] = 1 + prev[j-1];
                max = Math.max(max, dp[j]);
            }
            prev = dp;
        }
        return max;
    }
}

// abzd abcd
// 
//       a b z d
//     0 1 2 3 4
//     ___________
//   0|0 0 0 0 0
// a 1|0 1 0 0 0
// b 2|0 0 2 0 0
// c 3|0 0 0 0 0
// d 4|0 0 0 0 1
// max = 2

/*
https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
https://youtu.be/_wP9mWNPL5w - striver

 * You are given two strings s1 and s2. Your task is to find the length of the longest common substring among the given strings.

Examples:

Input: s1 = "ABCDGH", s2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" with a length of 4.
Input: s1 = "abc", s2 = "acb"
Output: 1
Explanation: The longest common substrings are "a", "b", "c" all having length 1.
 */