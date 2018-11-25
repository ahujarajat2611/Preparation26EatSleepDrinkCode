package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
/*
Bomb enemy

Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.
Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
/*

For each empty cell,
we can calculate how many enemies on its left, right, top
and bottom. Now the total enemies that cell can kill is the sum of all directions.
To calculate how many enemies a cell has on one direction, we use DP. For example, if we want to calculate enemies on the left side. If its left cell is an enemy, then it's left[i][j - 1] + 1. Else if the left cell is wall, then nothing can be killed. Otherwise it's equal to the left cell.

 */
public class BombEnemy {
    public int deadEnemies(int[][] enemies, int[][] walls, int m, int n) {
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];

        char[][] board = new char[m][n];

        for (int[] e : enemies) {
            board[e[0]][e[1]] = 'E';
        }

        for (int[] w : walls) {
            board[w[0]][w[1]] = 'W';
        }

        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j++) {
                left[i][j] = board[i][j + 1] == 'E' ? left[i][j + 1] + 1
                        : board[i][j + 1] == 'W' ? 0 : left[i][j + 1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                right[i][j] = board[i][j - 1] == 'E' ? right[i][j - 1] + 1
                        : board[i][j - 1] == 'W' ? 0 :right[i][j - 1];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = m - 2; i >= 0; i--) {
                up[i][j] = board[i + 1][j] == 'E' ? up[i + 1][j] + 1
                        : board[i + 1][j] == 'W' ? 0 : up[i + 1][j];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                down[i][j] = board[i - 1][j] == 'E' ? down[i - 1][j] + 1
                        : board[i - 1][j] == 'W' ? 0 : down[i - 1][j];
            }
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = Math.max(sum, left[i][j] + right[i][j] + up[i][j] + down[i][j]);
            }
        }
        return sum;
    }
}
