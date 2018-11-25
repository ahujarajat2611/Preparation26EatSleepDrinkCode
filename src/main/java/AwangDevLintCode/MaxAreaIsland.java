package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
public class MaxAreaIsland {
    /*
Thoughts:

DFS to all directions:
dx = {0, 1, 0, -1}
dy = {1, 0, -1, 0}
1. Each DFS deep dive returns the result area
2. Compare result with max area
Note: when island is found and counted into area, it needs to be flipped to other digits just to avoid revisiting.
*/
    private static int[] DX = {0, 1, 0, -1};
    private static int[] DY = {1, 0, -1, 0};
    private static int VISITED = -1;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            grid[x][y] = VISITED;
            int currentLevelSum = 1;
            for (int i = 0; i < DX.length; i++) {
                currentLevelSum += dfs(grid, x + DX[i], y + DY[i]);
            }
            return currentLevelSum;
        }
        return 0;
    }
}
