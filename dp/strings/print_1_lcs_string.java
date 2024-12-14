package dp.strings;

import java.util.Arrays;

public class print_1_lcs_string {

    public static void main(String[] args) {
        System.out.println(lcs("abcde", "bdgek"));
    }
    
    public static String lcs(String s, String t) {
		//Your code goes here
		int n = s.length(), m = t.length();
		int[][] dp = new int[n+1][m+1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
				else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		int lcs = dp[n][m];
        Arrays.stream(dp).forEach(row -> System.out.println(Arrays.toString(row)));

// ------------------------------------------------------------------------------

		String res = "";
		int i = n, j = m;
		while (i > 0 && j > 0) {
			if (s.charAt(i-1) == t.charAt(j-1)) {
				res = s.charAt(i-1) + res;
				i--;
				j--;
			}
			else if (dp[i][j-1] >= dp[i-1][j]) j--;
			else i--;
		}
		return res;
    }
}
