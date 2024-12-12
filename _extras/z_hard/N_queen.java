package _extras.z_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_queen {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        int[] row = new int[n];
        int[] col = new int[n];
        int[] diag45 = new int[2*n - 1];
        int[] diag135 = new int[2*n - 1];

        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, n, row, col, diag45, diag135, board, res);
        return res;
    }

    static void backtrack(int r, int queens, int n, int[] row, int[] col, int[] diag45, int[] diag135, char[][] board, List<List<String>> res) {
        if (r == n) {
            if (queens == 0) {
                List<String> solvedChessBoard = new ArrayList<>();
                Arrays.stream(board).forEach(chessRow -> solvedChessBoard.add(new String(chessRow)));
                res.add(solvedChessBoard);
            }
            return;
        }

        for (int c = 0; c < n; c++) {
            if (row[r] == 0 && col[c] == 0 && diag45[r+c] == 0 && diag135[c+n-1-r] == 0) {
                row[r] = 1;
                col[c] = 1;
                diag45[r+c] = 1;
                diag135[c+n-1-r] = 1;
                board[r][c] = 'Q';
                
                backtrack(r+1, queens-1, n, row, col, diag45, diag135, board, res);

                row[r] = 0;
                col[c] = 0;
                diag45[r+c] = 0;
                diag135[c+n-1-r] = 0;
                board[r][c] = '.';
            }
        }
    }
}
