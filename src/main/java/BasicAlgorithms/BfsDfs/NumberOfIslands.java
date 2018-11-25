package BasicAlgorithms.BfsDfs;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 21/10/17.
 */
// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// 11110
// 11010
// 11000
// 00000
// Answer: 1

// Example 2:

// 11000
// 11000
// 00100
// 00011
// Answer: 3
public class NumberOfIslands {
    int xdir[] = {1, 0, -1, 0};
    int ydir[] = {0, 1, 0, -1};
    int m;
    int n;

    public int numIslands(int[][] grid) {
        int number = 0;
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    dfsApply(grid, i, j, visited);
                    number++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(" "+visited[i][j]);
            }
            System.out.println();
        }

        return number;
    }

    private void dfsApply(int[][] grid, int x, int y, boolean[][] visited) {

        int m = grid.length;
        int n = grid[0].length;

        for (int k = 0; k < 4; k++) {
            int newx = x + xdir[k];
            int newy = y + ydir[k];
            if (isValid(newx, newy) && !visited[newx][newy] && grid[newx][newy] ==1) {
                visited[newx][newy] = true;
                dfsApply(grid, newx, newy, visited);
            }
        }
    }

    private boolean isValid(int newx, int newy) {
        if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };
        int [][]array2 = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(array2));
        System.out.println(numberOfIslands.numIslandsBfs(array2));
    }
    public int numIslandsBfs(int[][] grid) {
            int numberOfComponenets =0;
            m = grid.length;
            n = grid[0].length;
            boolean [][] visited = new boolean[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j] && grid[i][j] == 1){
                        bfsApply(grid,i,j,visited);
                        numberOfComponenets++;
                    }
                }
            }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(" "+visited[i][j]);
            }
            System.out.println();
        }
        return numberOfComponenets;
    }

    private void bfsApply(int[][] grid, int i, int j, boolean[][] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i*n+j);
        visited[i][j] = true;

        while (!queue.isEmpty()){
            int polled = queue.poll();
            int x = polled/n;
            int y = polled%n;

            for(int k=0;k<4;k++){
                int newx = x + xdir[k];
                int newy = y + ydir[k];

                if(isValid(newx,newy) && !visited[newx][newy] && grid[newx][newy] == 1){
                    queue.add(newx*n+newy);
                    visited[newx][newy] = true;
                }
            }
        }
    }

}
