package BasicAlgorithms.BfsDfs;

/**
 * Created by hadoop on 24/10/17.
 */
public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i, j, grid, visited);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private static int dfs(int row, int col, int[][] grid, boolean[][] visited) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col] && grid[row][col] == 1) {
            visited[row][col] = true;
            int res1 = dfs(row + 1, col, grid, visited);
            int res2 = dfs(row, col + 1, grid, visited);
            int res3 = dfs(row - 1, col, grid, visited);
            int res4 = dfs(row, col - 1, grid, visited);
            return res1 + res2 + res3 + res4 + 1;
        }
        return 0;
    }
}
