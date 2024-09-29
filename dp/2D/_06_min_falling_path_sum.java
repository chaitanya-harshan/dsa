public class _06_min_falling_path_sum {
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n+2];

        for (int i = n-1; i>=0; i--) {
            int[] row = new int[n+2];
            row[0] = Integer.MAX_VALUE;
            row[n+1] = Integer.MAX_VALUE;

            for (int j=1; j< n+1; j++) {
                int leftDiag = prev[j-1];
                int down = prev[j];
                int rightDiag = prev[j+1];

                row[j] = matrix[i][j-1] + Math.min(leftDiag, Math.min(down, rightDiag));
            }
            prev = row;
        }
        int result = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            result = Math.min(result, prev[1+i]);
        }
        return result;
    }
}

/*
 * 931. Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 * 
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100

 */