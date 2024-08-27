package recursion.lec3Hard;

import java.util.Arrays;

public class _02_word_search {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        int[][] used = new int[r][c];
        for (int[] row: used){
            Arrays.fill(row, 0);
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (board[i][j] == word.charAt(0) && 
                    dfs(i, j, 0, board, word, used, r, c) == true) return true;
            }
        }
        return false;
    }

    static boolean dfs(int row, int col, int k, char[][] board, String word, int[][] used, int r, int c) {
        if (k == word.length()) return true;

        if (row < 0 || row >= r || col < 0 || col >= c) return false;
        if (used[row][col] == 1) return false;
        if (board[row][col] != word.charAt(k)) return false;

        used[row][col] = 1;

        if (dfs(row-1, col, k+1, board, word, used, r, c) ||
            dfs(row+1, col, k+1, board, word, used, r, c) ||
            dfs(row, col-1, k+1, board, word, used, r, c) ||
            dfs(row, col+1, k+1, board, word, used, r, c)) {
            return true;
        }
        else used[row][col] = 0;
        return false;   
    }
}

// https://leetcode.com/problems/word-search/

// https://www.youtube.com/watch?v=pfiQ_PS1g8E
/*
 * 79. Word Search
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Input: board = 
[[ A , B , C , E ],
 [ S , F , C , S ],
 [ A , D , E , E ]]

word = "ABCCED"

 (A) ,  (B) , (C) , E ,
  S ,    F ,  (C) , S ,
  A ,   (D) , (E) , E 
Output: true
 */