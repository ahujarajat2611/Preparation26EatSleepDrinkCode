package BasicAlgorithms.BfsDfs;

/**
 * Created by hadoop on 2/3/18.
 */
public class PerimeterIslandMine {
    public int islandPerimeter(int[][] grid) {
        return islandPerimeterMine(grid);
    }
    public int islandPerimeterMine(int[][] grid) {
        if(grid.length ==0 || grid[0].length ==0){
            return 0;
        }
        //  return islandPerimeterHelper(grid,)
        int ans = 0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    System.out.println("here");
                    ans += isIslandPerimeter(grid,i,j,visited);
                }
            }
        }
        return ans;
    }

    int []dx = {1,0,-1,0};
    int []dy = {0,1,0,-1};
    private int isIslandPerimeter(int[][] grid, int i, int j, boolean[][] visited) {

        int count = 0;
        for(int k =0;k<dx.length;k++){
            System.out.println("here");
            if(!isValidMine(i+dx[k],j+dy[k],grid.length,grid[0].length)){
                count++;
                continue;
            }
            if(grid[i+dx[k]][j+dy[k]]==0){
                count++;
                continue;
            }
            if(visited[i+dx[k]][j+dy[k]]){
                continue;
            }
            visited[i+dx[k]][j+dy[k]] = true;
            count = count + isIslandPerimeter(grid,i+dx[k],j+dy[k],visited);
        }
        return count;
    }

    private boolean isValidMine(int i, int j, int m, int n) {
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PerimeterIslandMine perimeterIslandMine = new PerimeterIslandMine();
        int [][]grid = {{1,0}};
        System.out.println(perimeterIslandMine.islandPerimeter(grid));
    }
}
