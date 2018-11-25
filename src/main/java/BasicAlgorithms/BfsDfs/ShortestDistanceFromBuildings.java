package BasicAlgorithms.BfsDfs;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 21/10/17.
 */
	/*
				Shortest Distance from All Buildings
				You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You are given a 2D grid of values 0, 1 or 2, where:

				Each 0 marks an empty land which you can pass by freely.
				Each 1 marks a building which you cannot pass through.
				Each 2 marks an obstacle which you cannot pass through.
				The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

				For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

				1 - 0 - 2 - 0 - 1
				|   |   |   |   |
				0 - 0 - 0 - 0 - 0
				|   |   |   |   |
				0 - 0 - 1 - 0 - 0
				The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

				Note:
				There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
			*/
public class ShortestDistanceFromBuildings {
    int m;
    int n;
    int xdir []={1,0,-1,0};
    int ydir []={0,1,0,-1};
    public int shortestDistance(int[][] grid) {
        // very difficult to apply DFS hence chose BFS ..
        m = grid.length;
        n = grid[0].length;
        int distance [][] = new int[m][n];
        int isReachable [][] = new  int[m][n];
        int numberOfBuildings= 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    // We doing BFS from Buildings instead of free spaces
                    numberOfBuildings++;
                    boolean [][]visited = new boolean[m][n];
                    applyBfs(grid,distance,visited,isReachable,i,j);
                }
            }
        }
        int mindis = Integer.MAX_VALUE;
        int x= -1;
        int y = -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mindis>distance[i][j] && isReachable[i][j] ==numberOfBuildings){
                    mindis = distance[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        ConsoleWriter.printIntArray(distance);
        System.out.println();
        ConsoleWriter.printIntArray(isReachable);
        System.out.println(x);
        System.out.println(y);
        return mindis;
    }

    private void applyBfs(int[][] grid, int[][] distanceMatrix, boolean[][] visited,int[][] isRechable, int x, int y) {
        visited[x][y] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x*n+y);
        HashMap<Integer,Integer>  distance = new HashMap<>();
        distance.put(x*n+y,0);

        while (!queue.isEmpty()){
            int polled = queue.poll();
            x = polled/n;
            y = polled%n;
            int dis = distance.get(polled);
            for(int k=0;k<4;k++){
                int newx = x+xdir[k];
                int newy = y +ydir[k];
                if(isValid(newx,newy) && !visited[newx][newy] && grid[newx][newy]!=2 && grid[newx][newy]!=1){
                    visited[newx][newy] = true;
                    distanceMatrix[newx][newy] += dis+1;
                    distance.put(newx*n+newy,dis+1);
                    isRechable[newx][newy]++;
                    queue.add(newx*n+newy);
                }
            }
        }
    }
    private boolean isValid(int newx, int newy) {
        if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        ShortestDistanceFromBuildings shortestDistanceFromBuildings = new ShortestDistanceFromBuildings();
        int [][]grid ={{1,0,2,0,1},
                        {0,0,0,0,0},
                        {0,0,1,0,0}
                    };
        System.out.println(shortestDistanceFromBuildings.shortestDistance(grid));
    }
}