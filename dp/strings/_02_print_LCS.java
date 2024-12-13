package dp.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _02_print_LCS {
    // ********** T-L-E ***********
    public static List<String> all_longest_common_subsequences(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        
        int maxLen = dp[n][m];
        // System.out.println(maxLen);
        Set<String> res = new HashSet<>();
        generateStrings(s,t, n, m, "", res, dp, maxLen);
        List<String> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;
    }
    
    public static void generateStrings(String s, String t, int i, int j, String str, Set<String> res, int[][] dp, int len) {
        // System.out.print(str.length() +" ");
        if (str.length() == len) {
            res.add(str);
            return;
        }
        if (i == 0 || j == 0) {
            return;
        }
        
        if (s.charAt(i-1) == t.charAt(j-1)) {
            generateStrings(s,t,i-1,j-1, s.charAt(i-1)+str, res, dp, len);
        }
        else {
            int left = dp[i][j-1];
            int right = dp[i-1][j];
            
            if (left > right) generateStrings(s,t,i,j-1, str,res, dp, len);
            if (right > left) generateStrings(s,t,i-1,j, str,res, dp, len);
            else {
                generateStrings(s,t,i,j-1, str,res, dp, len);
                generateStrings(s,t,i-1,j, str,res, dp, len);
            }
        }
    }
}
