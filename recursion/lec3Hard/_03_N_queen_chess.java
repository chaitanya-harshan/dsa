package recursion.lec3Hard;

import java.util.List;
import java.util.ArrayList;

public class _03_N_queen_chess {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // chess board
        char[][] board = new char[n][n];
        for (char[] row : board) {
            for (int j = 0; j<board.length; j++) {
                row[j] = '.';
            }
        }
        // hash tables to check for position validity
        int[] row = new int[n];
        int[] diagonal_up = new int[2*n - 1];// (n-1) + (col - row)
        int[] diagonal_down = new int[2*n - 1]; // row + col

        backtrack(0, row, diagonal_up, diagonal_down, board, result, n);
        return result;
    }

    static void backtrack(int column, int[] row, int[] diag_up, int[] diag_down, char[][] board, List<List<String>> result, int n) {
        if (column == n) {
            result.add(constructList(board));
            return;
        }

        for (int i=0; i<n; i++) {
            if (row[i] == 0 && diag_up[(n-1) + column-i] == 0 && diag_down[i+column] == 0) {
                board[i][column] = 'Q';
                // hashing 
                row[i] = 1;
                diag_up[(n-1) + column-i] = 1;
                diag_down[i+column] = 1;

                backtrack(column+1, row, diag_up, diag_down, board, result, n);

                // De-hashing
                row[i] = 0;
                diag_up[(n-1) + column-i] = 0;
                diag_down[i+column] = 0;
                board[i][column] = '.';
            }
        }
    }

    // converting 2D array into a list of strings where each row of the matrix is converted into 1 string
    static List<String> constructList(char[][] board) {
        List<String> list= new ArrayList<>();
        for (char[] row : board) {
            String str = new String(row);
            list.add(str);
        }
        return list;
    }
}

/*
https://leetcode.com/problems/n-queens/description/
https://youtu.be/i05Ju7AftcM

 * 51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Input: n = 1
Output: [["Q"]]
 */
