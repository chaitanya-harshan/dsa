package recursion.lec3Hard;

/**
 * _06_suduko
 */
public class _07_suduko {

    public void solveSudoku(char[][] board) {
        solve(board, 0,0);
    }

    static boolean solve(char[][] board, int row_start,int col_start) {
        // iterating though the board to find the empty cells
        for (int i=row_start; i<board.length; i++) {
            for (int j=col_start; j<board.length; j++) {

                if (board[i][j] == '.') {// upon finding the empty cell

                    for (char c='1'; c<='9'; c++) {
                        if (isValid(c, i, j, board)) {
                            board[i][j] = c; // putting the num in the cell
                            // ** i fucking dont know why it always have to start from 0 for new func call**
                            if (solve(board, 0, 0)) return true; // calling recursion for to solve next empty space
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;// for ending recursion call where all the spaces are filled so it just needs to return true 
    }

    static boolean isValid(char c, int row, int col, char[][] board) {
        for (int i=0; i<board.length; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[3*(row/3) + i/3][3*(col/3) + i % 3] == c) return false;
        }
        return true;
    }
}

/*
https://leetcode.com/problems/sudoku-solver/description/
https://youtu.be/FWAIf_EVUKE?list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma

 * A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Input: board = 
[[5 3 .   . 7 .    . . .] 
[6 . .    1 9 5    . . .] 
[. 9 8    . . .    . 6 .] 

[8 . .    . 6 .    . . 3] 
[4 . .    8 . 3    . . 1] 
[7 . .    . 2 .    . . 6] 

[. 6 .    . . .    2 8 .] 
[. . .    4 1 9    . . 5] 
[. . .    . 8 .    . 7 9]]
Output: 
[[5 3 4    6 7 8    9 1 2] 
[6 7 2    1 9 5    3 4 8] 
[1 9 8    3 4 2    5 6 7] 

[8 5 9    7 6 1    4 2 3] 
[4 2 6    8 5 3    7 9 1] 
[7 1 3    9 2 4    8 5 6] 

[9 6 1    5 3 7    2 8 4] 
[2 8 7    4 1 9    6 3 5] 
[3 4 5    2 8 6    1 7 9]]
 */