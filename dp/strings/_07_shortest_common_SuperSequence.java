package dp.strings;

public class _07_shortest_common_SuperSequence {
    
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i=1; i<= n; i++) {
            for (int j=1; j<=m; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
    // ----------------------------------------------------------------------------------------
        String res = "";
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                res = str1.charAt(i-1) + res;
                i--;
                j--;
            }
            else if (dp[i][j-1] > dp[i-1][j]) {
                res = str2.charAt(j-1) + res;
                j--;
            }
            else {
                res = str1.charAt(i-1) + res;
                i--;
            }
        }

        while (i > 0) {
            res = str1.charAt(i-1) + res;
            i--;
        }
        while (j > 0) {
            res = str2.charAt(j-1) + res;
            j--;
        }

        return res;
    }
}
