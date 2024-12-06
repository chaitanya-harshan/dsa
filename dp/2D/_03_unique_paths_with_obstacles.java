public class _03_unique_paths_with_obstacles {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];

        for (int i=m-1; i>=0; i--) {
            int[] dp = new int[n];
            dp[n-1] = i == m-1 ? 1 : 0;

            for (int j = n-1; j>=0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // for case where the end is also a obstacle [[0,0],[0,1]]
                    continue;
                } 
                dp[j] += prev[j];
                if (j < n-1) dp[j] += dp[j+1];
            }
            prev = dp;
        }
        return prev[0];
    }
}

/*
 * https://leetcode.com/problems/unique-paths-ii/description/
 * 63. Unique Paths II
 * 
 * You are given an m x n integer array grid. There is a robot initially located at the 
 * top-left corner (i.e., grid[0][0]). 
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
 * The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes 
cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 10^9.

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
 */