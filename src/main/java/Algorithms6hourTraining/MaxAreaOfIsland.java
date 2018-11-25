package Algorithms6hourTraining;

/**
 * Created by hadoop on 21/12/17.
 */
// if gridis 1,1 then expand and get ands from its children using recursion
public class MaxAreaOfIsland {
    int dx[]= {1,0,-1,0};
    int dy[] = {0,1,0,-1};
    public int maxAreaOfIsland(int[][] grid) {

        int max_area = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;i<grid[i].length;j++){
                if(grid[i][j] ==1){
                    // like wise try to find all possible islands and get ans //
                    // better to keep visited array
                    max_area = Math.max(max_area,AreaOfIsland(grid,i,j));
                }
            }
        }
        return max_area;
    }

    private int AreaOfIsland(int[][] grid,int i,int j) {
        if(isValid(grid,i,j) && grid[i][j] == 1){
            // avoid updating grid better have visited array , i have suffreed
            grid[i][j] = 0;
            // add 1 andd ask its children to please return me ans kind of preorders
            // check things at current root and then asks its children to return me appropriate ans
            int area = 1;
            for(int k=0;k<4;k++){
                area+=AreaOfIsland(grid,i+dx[k],j+dy[k]);
            }
            return area;
        }
        return 0;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        if(i<grid.length && i>=0 && j<grid[0].length && j>=0){
            return true;
        }
        return false;
    }
}
