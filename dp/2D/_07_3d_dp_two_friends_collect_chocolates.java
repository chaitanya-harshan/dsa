public class _07_3d_dp_two_friends_collect_chocolates {
    
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(solve(4, 3, grid));
    }

    public static int solve(int m, int n, int[][] grid) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dp[i][j] = grid[m-1][i];
                else dp[i][j] = grid[m-1][i] + grid[m-1][j];
            }
        }

        for (int i = m-2; i >= 0; i--) {

            int[][] dpNew = new int[n][n];
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    
                    int sum;
                    if (j1 == j2) sum = grid[i][j1];
                    else sum = grid[i][j1] + grid[i][j2];

                    int bottom, maxBottom = Integer.MIN_VALUE;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            if (j1+di < 0 || j2+dj < 0 || j1+di >= n || j2+dj >= n) bottom = Integer.MIN_VALUE;
                            else bottom = dp[j1+di][j2+dj];
                            maxBottom = Math.max(bottom, maxBottom);
                        }
                    }
                    dpNew[j1][j2] = sum + maxBottom;
                }
            }
            dp = dpNew;
        }
        return dp[0][n-1]; // becasue they both are at (0,0) & (0,n-1)
    }
}
