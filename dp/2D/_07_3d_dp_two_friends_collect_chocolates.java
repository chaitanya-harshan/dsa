import java.util.Arrays;

public class _07_3d_dp_two_friends_collect_chocolates {
    
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(solve(4, 3, grid));
        System.out.println(maximumChocolates(4, 3, grid));
    }

    // tabulation  (below there is code for memoization)
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


    // Memoization - easier for this problem
    // https://bit.ly/3U9k6XT - gfg
    public static int maximumChocolates(int n, int m, int[][] grid) {
		// Write your code here.
		int[][][] dp = new int[n][m][m];
		Arrays.stream(dp).forEach(slice -> Arrays.stream(slice).forEach(row -> Arrays.fill(row,-1)));

		return backtrack(0, 0, m-1, grid, dp, n, m);
	}

	static int backtrack(int i, int j1, int j2, int[][] grid, int[][][] dp, int n, int m) {
		if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
			return Integer.MIN_VALUE;

		if (i == n-1) {
			if (j1 == j2) return grid[i][j1];
			else return grid[i][j1] + grid[i][j2];
		}

		if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

		int max = Integer.MIN_VALUE;
		for (int da = -1; da <= 1; da++) {
			for (int db = -1; db <= 1; db++) {
				int ans;
				if (j1 == j2)
					ans = grid[i][j1] + backtrack(i+1, j1+da, j2+db, grid, dp, n, m);
				else ans = grid[i][j1] + grid[i][j2] + backtrack(i+1, j1+da, j2+db, grid, dp, n, m);
				
				max = Math.max(max, ans);
			}
		}
		return dp[i][j1][j2] = max;
	}
}
