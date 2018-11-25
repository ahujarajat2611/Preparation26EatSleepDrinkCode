package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class NumIsland {
    public int numIslands(char[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1' ){
            grid[i][j] = '2';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
