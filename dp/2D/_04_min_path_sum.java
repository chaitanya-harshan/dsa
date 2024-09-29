
import java.util.Arrays;



public class _04_min_path_sum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[n-1] = 0;

        for (int i=m-1; i>=0; i--) {
            int[] row = new int[n];
            row[n-1] = grid[i][n-1] + prev[n-1];

            for (int j=n-2; j>=0; j--) {
                row[j] = grid[i][j] + Math.min(row[j+1], prev[j]);
            }
            prev = row;
        }
        return prev[0];

        // int[] prev = new int[n+1];
        // Arrays.fill(prev, Integer.MAX_VALUE);
        // prev[n-1] = 0;

        // for (int i = m-1; i >= 0; i--) {
        //     int[] row = new int[n+1];
        //     row[n] = Integer.MAX_VALUE;

        //     for (int j = n-1; j>=0; j--) {
        //         row[j] = grid[i][j] + Math.min(row[j+1], prev[j]);
        //     }
        //     prev = row;
        // }
        // return prev[0];
    }
}

/*
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/description/
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
 */