package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 13/12/17.
 */
public class CherryPickUpTwoPersonDp {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][][] dp = new int[N][N][N][N];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                for (int j2 = 0; j2 < dp.length; j2++) {
                    for (int k = 0; k < dp.length; k++) {
                        dp[i][j][j2][k] = -1;
                    }
                }
            }
        }
        int res = cherryPickup(grid, dp, 0, 0, 0, 0);
        if (res < 0) {
            return 0;
        } else {
            return res;
        }
    }

    private int cherryPickup(int[][] grid, int[][][][] dp, int i, int j, int k, int l) {
        int n = grid.length;
        if (dp[i][j][k][l] != -1) {
            return dp[i][j][k][l];
        }
        int res = 0;
        if (grid[i][j] == 1) {
            res++;
        }
        if (grid[k][l] == 1 && !(i == k && j == l)) {
            res++;
        }
        if (i == n - 1 && j == n - 1 && k == n - 1 && l == n - 1) {
            dp[i][j][k][l] = res;
            return res;
        }
        int max = -2;

        if (i < n - 1 && k < n - 1 && grid[i + 1][j] != -1 && grid[k + 1][l] != -1) {
            max = Math.max(max, cherryPickup(grid, dp, i + 1, j, k + 1, l));
        }
        if (i < n - 1 && l < n - 1 && grid[i + 1][j] != -1 && grid[k][l + 1] != -1) {
            max = Math.max(max, cherryPickup(grid, dp, i + 1, j, k, l + 1));
        }
        if (j < n - 1 && l < n - 1 && grid[i][j + 1] != -1 && grid[k][l + 1] != -1) {
            max = Math.max(max, cherryPickup(grid, dp, i, j + 1, k, l + 1));
        }
        if (j < n - 1 && k < n - 1 && grid[i][j + 1] != -1 && grid[k + 1][l] != -1) {
            max = Math.max(max, cherryPickup(grid, dp, i, j + 1, k + 1, l));
        }
        if (max == -2) {
            dp[i][j][k][l] = -2;
            return dp[i][j][k][l];
        }
        res += max;
        dp[i][j][k][l] = res;
        return res;
    }
    /* My solution
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][][] dp = new int[N][N][N][N];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                for (int j2 = 0; j2 < dp.length; j2++) {
                    for (int k = 0; k < dp.length; k++) {
                        dp[i][j][j2][k] = -1;
                    }
                }
            }
        }
        int res = cherryPickup(grid, dp, 0, 0, 0, 0);
        if (res < 0) {
            return 0;
        } else {
            return res;
        }
    }
    private int cherryPickup(int[][] grid, int[][][][] dp, int i, int j, int k, int l) {
        int n = grid.length;
        if (dp[i][j][k][l] != -1) {
            return dp[i][j][k][l];
        }
        int res = 0;
        if (grid[i][j] == 1) {
            res++;
        }
        if (grid[k][l] == 1 && !(i == k && j == l)) {
            res++;
        }
        if (i == n - 1 && j == n - 1 && k == n - 1 && l == n - 1) {
            // if(grid[n-1][n-1] == -1) {
            //     return Integer.MIN_VALUE;
            // }
            dp[i][j][k][l] = res;
            return res;
        }
        int max = Integer.MIN_VALUE;

        if (i < n - 1 && k < n - 1 && grid[i + 1][j] != -1 && grid[k + 1][l] != -1) {
            max = Math.max(max, cherryPickup(grid, dp, i + 1, j, k + 1, l));
        }
        if (i < n - 1 && l < n - 1 && grid[i + 1][j] != -1 && grid[k][l + 1] != -1) {
            max = Math.max(max, cherryPickup(grid, dp, i + 1, j, k, l + 1));
        }
        if (j < n - 1 && l < n - 1 && grid[i][j + 1] != -1 && grid[k][l + 1] != -1) {
            max = Math.max(max, cherryPickup(grid, dp, i, j + 1, k, l + 1));
        }
        if (j < n - 1 && k < n - 1 && grid[i][j + 1] != -1 && grid[k + 1][l] != -1) {
            max = Math.max(max, cherryPickup(grid, dp, i, j + 1, k + 1, l));
        }
        // if (max == Integer.MIN_VALUE) {
        //     dp[i][j][k][l] = Integer.MIN_VALUE;
        //     return dp[i][j][k][l];
        // }
        res += max;
        dp[i][j][k][l] = res;
        return res;
    }
     */
}
