package recursion.lec3Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _04_rat_in_Maze {

    public static ArrayList<String> findPath(int[][] mat) {
        // Your code here
        if (mat[0][0] == 0) return new ArrayList<>();
        
        int n = mat.length;
        ArrayList<String> paths = new ArrayList<>();
        int[][] visited = new int[n][n];
        for (int[] row: visited) {
            Arrays.fill(row, 0);
        }
        visited[0][0] = 1;
        
        findPath(0,0, visited, mat, paths, "", n);
        return paths;
    }
    
    static void findPath(int row, int col, int[][] visited, int[][] mat, List<String> paths, String path, int n) {
        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }
        
        char[] directions = {'U','D','L','R'};
        int[] rC = {-1,1,0,0}; // how much rowChange
        int[] cC = {0,0,-1,1}; // how much colChange
        
        for (int i=0; i<4; i++) {
            int rowNxt = row + rC[i];
            int colNxt = col + cC[i];

            if (isValid(directions[i], rowNxt, colNxt, visited, mat, n)) {
                visited[rowNxt][colNxt] = 1;
                findPath(rowNxt, colNxt, visited, mat, paths, path+directions[i], n);
                visited[rowNxt][colNxt] = 0;
            }
        }
    }
    
    static boolean isValid(char direction, int row, int col, int[][] visited, int[][] mat, int n) {
        if (row < 0 || row > n-1 || col < 0 || col > n-1) return false;
        if (mat[row][col] == 0) return false;
        if (visited[row][col] == 1) return false;
        return true;
    }
}

/*

https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
https://youtu.be/bLGZhJlt4y0

Rat in a Maze Problem - I

 * Consider a rat placed at (0, 0) in a square matrix mat of order n* n. 
 * It has to reach the destination at (n - 1, n - 1). 
 * Find all possible paths that the rat can take to reach from source to destination. 
 * The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).
 *  Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. I
f the source cell is 0, the rat cannot move to any other cell. 
In case of no path, return an empty list. The driver will output "-1" automatically.
 */
