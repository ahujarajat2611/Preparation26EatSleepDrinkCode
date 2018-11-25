package BasicAlgorithms.BfsDfs;

/**
 * Created by hadoop on 10/1/18.
 */
public class PerimeterIsland {
    private class Solution {
        public int islandPerimeter(int[][] grid) {
            int perimeter=0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    // if its valid dont addd it but if its neighbours not valid
                    // then addd perimeter
                    if(!isValid(grid,i,j)) continue;
                    if(!isValid(grid,i-1,j)) perimeter++; //left
                    if(!isValid(grid,i+1,j)) perimeter++; //right
                    if(!isValid(grid,i,j-1)) perimeter++; //top
                    if(!isValid(grid,i,j+1)) perimeter++; //bottom
                }
            }
            return perimeter;
        }

        private boolean isValid(int[][] grid, int p,int q){
            if(p<0||p>=grid.length||q<0||q>=grid[0].length||grid[p][q]==0) return false;
            return true;
        }
    }


    public int islandPerimeterMine(int[][] grid) {

      //  return islandPerimeterHelper(grid,)
        int ans = 0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
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
            if(!isValidMine(i+dx[k],j+dy[k],grid.length,grid[0].length)){
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

}
/*
public int islandPerimeter(int[][] grid) {
    int[][] d = new int[][] {{0,-1}, {-1,0}, {0,1}, {1,0}};

    int perimeter = 0;
    for(int i=0; i<grid.length; i++) {
        for(int j=0; j<grid[0].length; j++) {
            if(grid[i][j] == 0)
                continue;

            for(int k=0; k<d.length; k++) {
                int x=i+d[k][0], y=j+d[k][1];
                if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y] == 0)
                    perimeter++;
            }
        }
    }

    return perimeter;
}
 */
/*
wattaasolution
public int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == 1) {
                    return getPerimeter(grid,i,j);
                }
            }
        }
        return 0;
    }


public int getPerimeter(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {return 1;}
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) return 0;
        int count = 0;
        grid[i][j] = -1;
        count += getPerimeter(grid, i-1, j);
        count += getPerimeter(grid, i, j-1);
        count += getPerimeter(grid, i, j+1);
        count += getPerimeter(grid, i+1, j);
        return count;
    }
 */
/*
//void dfs(vector<vector<int>>& b, int *ans, int i, int j) {
//        if (i < 0 || i >= b.size() || j < 0 || j >= b[0].size() || b[i][j] != 1)
//            return;
//        b[i][j] = -1; // mark it as visited
//        *ans += (j + 1 >= b[0].size() || b[i][j+1] == 0) /* right */
//        (i - 1 < 0            || b[i-1][j] == 0) /* top */ +
//        (j - 1 < 0            || b[i][j-1] == 0) /* left */ +
//        (i + 1 >= b.size()    || b[i+1][j] == 0) /* bottom */;
//        dfs(b, ans, i, j + 1);
//        dfs(b, ans, i - 1, j);
//        dfs(b, ans, i, j - 1);
//        dfs(b, ans, i + 1, j);
//        return;
//        }
//        int islandPerimeter(vector<vector<int>>& grid) {
//        int ans = 0, i, j;
//        for (i = 0; i < grid.size(); i++) {
//        for (j = 0; j < grid[0].size(); j++) {
//        if (grid[i][j]) {
//        dfs(grid, &ans, i, j);
//        return ans;
//        }
//        }
//        }
//        return 0;
//        }
// */
// /*



