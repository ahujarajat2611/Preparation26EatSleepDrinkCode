package BasicAlgorithms.BfsDfs;
// You are given a m x n 2D grid initialized with these three possible values.

// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

// For example, given the 2D grid:
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
// After running your function, the 2D grid should be:
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4

// thats amaazing solution ... with DFS usual though ptocess is BFS but think outside the box

// idea is to publish DFS from gate .... and u will see result
// we can do with BFS as well but we need to map row and column to one number ..
// also need to keep track of distance

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.*;

/**
 * Created by hadoop on 21/10/17.
 */
public class WallAndGates {

    int[] xdir = {1, 0, -1, 0};
    int[] ydir = {0, 1, 0, -1};
    int m;
    int n;
    private static int INF = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {
        m = rooms.length;
        n = rooms[0].length;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
      //  dfs(rooms,0,2,0);
    }

    private void dfs(int[][] rooms, int x, int y, int d) {

        // here do u think it wil go in infitine loop ..

        for (int k = 0; k < 4; k++) {
            int newx = x + xdir[k];
            int newy = y + ydir[k];
            if (isValid(newx, newy) && rooms[newx][newy]!=-1) {
                if (rooms[newx][newy] > d + 1) {
                    rooms[newx][newy] = d+1;
                    dfs(rooms, newx, newy, d + 1);
                }
            }
        }
    }


    private boolean isValid(int newx, int newy) {
        if (newx >= 0 && newx < m && newy >= 0 && newy < n ) {
            return true;
        }
        return false;
    }
    public void wallsAndGatesBfs(int[][] rooms) {
        // Its BFS from multiple sources at same time dude
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j] ==0){
                    list.add(i*rooms[0].length+j);
                }
            }
        }
        bfsFromMultipleSources(list,rooms);
    }

    private void bfsFromMultipleSources(List<Integer> list, int[][] rooms) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer,Integer> distance = new HashMap<>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                distance.put(i*rooms[0].length+j,INF);
            }
        }
        for(Integer source:list){
            distance.put(source,0);
            queue.add(source);
        }
        m = rooms.length;
        n = rooms[0].length;

        boolean visited[][] = new boolean[rooms.length][rooms[0].length];
        while(!queue.isEmpty()){
            int popped = queue.poll();
            int x = popped/rooms[0].length;
            int y = popped%rooms[0].length;
            for(int k=0;k<4;k++){
                int newx = x+xdir[k];
                int newy = y+ydir[k];
                System.out.println(newx);
                System.out.println(newy);
                System.out.println(isValid(newx,newy));
              //  System.out.println(rooms[newx][newy]!=-1);
               // System.out.println(visited[newx][newy]);
                if(isValid(newx,newy) && rooms[newx][newy]!=-1 && !visited[newx][newy]  && distance.get(newx*rooms[0].length +newy)>(distance.get(x*rooms[0].length+y)+1)){
                    System.out.println("entry here");
                    int v = newx*rooms[0].length+newy;
                    distance.put(v,distance.get(popped)+1);
                    visited[newx][newy] = true;
                    rooms[newx][newy] = distance.get(popped)+1;
                    queue.add(v);
                }
            }

        }
    }

    public static void main(String[] args) {
        int rooms[][] = {{INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}};

        WallAndGates wallAndGates = new WallAndGates();
        wallAndGates.wallsAndGates(rooms);
        //wallAndGates.wallsAndGatesBfs(rooms);
        ConsoleWriter.printIntArray(rooms);

    }
}
//3	-1	0	1
//        2	2	1	-1
//        1	-1	2	-1
//        0	-1	3	4