package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 19/1/18.
 */
/*
Longest Increasing Path in a Matrix
Given an integer matrix, find the length of the longest increasing path.
From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
Example 1:
nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].
Example 2:
nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
The question is marked hard, but the idea is not very difficult. We still use DFS, but the trick here is we track a traversed matrix, which stores the longest path current coordinate can have if it is traversed previously. Update the traversed matrix every time we finish traversing all neighbors of a point.

Note here we first check all neighbors of a point, then update the point with the longest path we can fin
 */
public class LongesrIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int max = 0;
        int[][] traversed = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, traverse(matrix, i, j, traversed, -1));
            }
        }
        return max;

    }
    private int traverse(int[][] matrix, int x, int y, int[][]traversed, int former) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= former)
            return 0;
        if (traversed[x][y] != 0)
            return traversed[x][y];
        int right = traverse(matrix, x + 1, y, traversed, matrix[x][y]);
        int left = traverse(matrix, x - 1, y, traversed, matrix[x][y]);
        int up = traverse(matrix, x, y - 1, traversed, matrix[x][y]);
        int down = traverse(matrix, x, y + 1, traversed, matrix[x][y]);
        int maxCurr = Math.max(Math.max(left, right), Math.max(up, down));
        traversed[x][y] = maxCurr + 1;
        return traversed[x][y];
    }
}
