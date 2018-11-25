package BasicAlgorithms.BfsDfs;

/**
 * Created by hadoop on 23/2/18.
 */
import java.util.*;
public class MazeII {
    private class Point {
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dirx = {1, 0, -1, 0};
    static int[] diry = {0, -1, 0, 1};
    int m;
    int n;

    private class IndexedNode{
        Point point;
        Integer distance;
        IndexedNode(Point p,Integer distance){
            this.distance = distance;
            this.point = p;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        PriorityQueue<IndexedNode>pq = new PriorityQueue<>(new Comparator<IndexedNode>() {
            @Override
            public int compare(IndexedNode o1, IndexedNode o2) {
                return o1.distance-o2.distance;
            }
        });
        HashMap<Point,Integer> distance = new HashMap<>();
        HashMap<Point,Point> edgeTo = new HashMap<>();
        Point startPoint = new Point(start[0],start[1]);
        pq.add(new IndexedNode(startPoint,0));
        distance.put(startPoint,0);
        edgeTo.put(startPoint,null);

        while (!pq.isEmpty()){
            IndexedNode polled = pq.poll();
            int dist = polled.distance;
            if (isEndConfiguration(polled.point, destination)) {
                return dist;
            }
            for(int i=0;i<4;i++){
                Object neighbour[] = getNextValid(polled.point, dirx[i], diry[i], maze);
                if(neighbour == null){
                    continue;
                }
                Integer neighBourDistance = distance.get(neighbour[0]);
                if(neighBourDistance == null){
                    distance.put((Point)neighbour[0],dist+(Integer)neighbour[1]);
                    edgeTo.put((Point)neighbour[0],polled.point);
                    pq.add(new IndexedNode((Point)neighbour[0],dist+(Integer)neighbour[1]));
                }
                else if(neighBourDistance >dist+(Integer)neighbour[1]){
                    distance.put((Point)neighbour[0],dist+(Integer)neighbour[1]);
                    edgeTo.put((Point)neighbour[0],polled.point);
                    pq.add(new IndexedNode((Point)neighbour[0],dist+(Integer)neighbour[1]));
                }
            }
        }
        return -1;
    }
    private boolean isEndConfiguration(Point point, int[] destination) {
        if (point.x == destination[0] && point.y == destination[1]) {
            return true;
        }
        return false;
    }
    private Object[] getNextValid(Point p, int xdir, int ydir, int[][] maze) {
        int counter = 0;
        int savex = p.x;
        int savey = p.y;
        int x = p.x;
        int y = p.y;
        int dis = 0;
        while (isValid(x + xdir, y + ydir) && maze[x + xdir][y + ydir] != 1) {
            counter++;
            x = x + xdir;
            y = y + ydir;
            dis++;
            if (counter > 10000) System.exit(1);

        }
        if (savex == x && savey == y) {
            return null;
        }
        return new Object[]{new Point(x, y),dis};
    }
    private boolean isValid(int newx, int newy) {
        if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
            return true;
        }
        return false;
    }
}
