package BasicAlgorithms.BfsDfs;

/**
 * Created by hadoop on 23/2/18.
 */
import java.util.*;
public class MazeI {
    int xdir []= {1,0,-1,0};
    int ydir [] = {0,1,0,-1};
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        boolean visited [][] = new boolean[maze.length][maze[0].length];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start[0]*n+start[1]);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()){
            Integer polled = queue.poll();
            int x= polled/n;
            int y = polled%n;
            if(x == destination[0] && y == destination[1]){
                return true;
            }
            //System.out.println("x "+x);
            //System.out.println("y "+y);
            for(int i=0;i<4;i++){
                //System.out.println("entry");
                //System.out.println();
                int []directions = getNextValid(x,y,xdir[i],ydir[i],visited,maze);
                if(directions !=null) {
                    if (!visited[directions[0]][directions[1]]) {
                        visited[directions[0]][directions[1]] = true;
                        queue.add(directions[0] * n + directions[1]);
                    }
                }
            }

        }
        return false;
    }

    private int[] getNextValid(int x, int y, int xdir, int ydir, boolean[][] visited, int[][] maze) {

        int savex = x;
        int savey = y;
        while (isValid(x+xdir,y+ydir) && maze[x+xdir][y+ydir] !=1){
            x = x + xdir;
            y = y +ydir;
        }
        if(savex == x && savey == y){
            return null;
        }
        return new int[]{x,y};
    }

    private boolean isValid(int newx, int newy) {
        if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
            return true;
        }
        return false;
    }
}
