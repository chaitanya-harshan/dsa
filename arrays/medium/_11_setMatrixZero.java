package arrays.medium;

import java.util.Arrays;

public class _11_setMatrixZero {

    public static void main(String[] args) {
        // int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        
        int[][] arr1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        // setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        setZeroes(arr1);
        System.out.println(Arrays.deepToString(arr1));
    }

    static void setZeroes(int[][] matrix) {
        int col0 = -1;
        for (int i=0; i< matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) matrix[0][j] = 0;
                    else col0 = 0; 
                }
            }
        }

        for (int i=0; i<matrix.length; i++) {
            if (i != 0 && matrix[i][0] == 0) rows(matrix, i);
        }
        for (int i=0; i<matrix[0].length; i++) {
            if (i != 0 && matrix[0][i] == 0) columns(matrix, i);
        }
        if (matrix[0][0] == 0) rows(matrix, 0);
        if (col0 == 0) columns(matrix, 0);
    }

    static void rows(int[][] matrix, int row) {
        for (int j=0; j<matrix[0].length; j++) 
            matrix[row][j] = 0;
    } 

    static void columns(int[][] matrix, int column) {
        for (int i=0; i<matrix.length; i++) 
            matrix[i][column] = 0;
    }
}


/*
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
 */