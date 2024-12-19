package arrays.neetcode;

import java.util.HashSet;

public class _08_valid_suduko {
    
    public boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            HashSet<Character> set = new HashSet<>();
            for (char c : row) {
                if (c == '.') continue;
                if (set.contains(c)) return false;
                else set.add(c);
            }
        }

        for (int j=0; j<9; j++) {
            HashSet<Character> set = new HashSet<>();
            for (int i=0; i<9; i++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (set.contains(c)) return false;
                else set.add(c);
            }
        }

        for (int sq = 0; sq<9; sq++) {
            HashSet<Character> set = new HashSet<>();
            int row0 = sq/3 * 3;
            int col0 = sq%3 * 3;
            
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    char c = board[row0 + i][col0 + j];
                    if (c == '.') continue;
                    if (set.contains(c)) return false;
                    else set.add(c);
                }
            }
        }

        return true;
 

        // this is way too complicated and you didn't have to do all this.
        // HashSet<Character>[] col = new HashSet[9];
        // for (int i=0; i<9; i++) col[i] = new HashSet<>();

        // HashSet<Character>[] cube = new HashSet[3];
        // for (int i=0; i<3; i++) cube[i] = new HashSet<>();

        // for (int i=0; i<9; i++) {
        //     HashSet<Character> row = new HashSet<>();
        //     if (i == 3 || i == 6) {
        //         for (int ci=0; ci<3; ci++) cube[ci] = new HashSet<>();
        //     }

        //     for (int j=0; j<9; j++) {
        //         char c = board[i][j];
        //         if (c == '.') continue;
        //         if (row.contains(c) || col[j].contains(c)) return false;
        //         if (cube[j/3].contains(c)) return false;

        //         row.add(c);
        //         col[j].add(c);
        //         cube[j/3].add(c);
        //     }
        // }
        // return true;
    }
}

/*
 * 36. Valid Sudoku
https://leetcode.com/problems/valid-sudoku/description/

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */

 /*
  * Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
  */