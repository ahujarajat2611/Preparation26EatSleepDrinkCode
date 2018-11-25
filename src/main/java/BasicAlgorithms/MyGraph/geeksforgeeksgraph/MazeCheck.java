package BasicAlgorithms.MyGraph.geeksforgeeksgraph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 25/10/17.
 */
public class MazeCheck {
    // bfs, like-dijikstra
    static int[] dirx = {1, 0, -1, 0};
    static int[] diry = {0, -1, 0, 1};
    int m;
    int n;

    private class Point {
        int x;
        int y;
        int distance; // it is required to stich distance to node

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
          //  if (y != point.y) return false;
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            //result = 31 * result + distance;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", distance=" + distance +
                    '}';
        }
    }

    public int shortDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.distance - o2.distance;
            }
        });
        HashMap<Point, Integer> dist = new HashMap<>();
        HashMap<Point, Point> edgeTo = new HashMap<>();
        //HashSet<Point> nodesAlreadyVisited = new HashSet<>();
        Point startPoint = new Point(start[0], start[1], 0);
        pq.add(startPoint);
        edgeTo.put(startPoint, null);
        dist.put(startPoint, 0);
        int counter = 0;
        while (!pq.isEmpty()) {
            counter++;
            Point point = pq.poll();
            int distance = dist.get(point);
            if (isEndConfiguration(point, destination)) {
                return distance;
            }
            if (counter > 10000) System.exit(1);
            System.out.println("po"+point);
//            if (nodesAlreadyVisited.contains(point)){
//                System.out.println("loop back");
//                continue;
//            }
           // System.out.println("addeDsucc "+nodesAlreadyVisited.add(point));

            for (int i = 0; i < 4; i++) {
                if (counter > 10000) System.exit(1);
                Point neighbour = getNextValid(point, dirx[i], diry[i], maze);
               // System.out.println("contain"+nodesAlreadyVisited.contains(neighbour));
                if (neighbour == null) continue;
                //if (nodesAlreadyVisited.contains(neighbour))
                 //   continue;
                if (neighbour != null) {
                    System.out.println("point to Neighbour " + point + "  " + neighbour);
                }
                if (dist.get(neighbour) == null) {
                    dist.put(neighbour, neighbour.distance);
                    System.out.println("myans"+dist.get(neighbour));
                    pq.offer(neighbour);
                    edgeTo.put(neighbour, point);
                } else {
                    if (dist.get(neighbour) > neighbour.distance) {
                        System.out.println(dist.get(neighbour));
                //        pq.offer(neighbour);
                        dist.put(neighbour, neighbour.distance);
                        edgeTo.put(neighbour, point);
                    }
                }
            }
        }

        return -1;
    }

    private Point getNextValid(Point p, int xdir, int ydir, int[][] maze) {
        int counter = 0;
        int savex = p.x;
        int savey = p.y;
        int x = p.x;
        int y = p.y;
        int distance = p.distance;
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
        return new Point(x, y, distance + dis);
    }

    private boolean isValid(int newx, int newy) {
        if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
            return true;
        }
        return false;
    }

    private boolean isEndConfiguration(Point point, int[] destination) {
        if (point.x == destination[0] && point.y == destination[1]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MazeCheck mazeCheck = new MazeCheck();
        int matrix[][] = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        System.out.println(mazeCheck.shortDistance(matrix, new int[]{0, 4}, new int[]{3, 2}));

        //mazeCheck.check();

    }

    public void check() {
        PriorityQueue<Point> priorityQueue = new PriorityQueue(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.distance - o1.distance;
            }
        });
        Point p = new Point(1, 2, 4);
        Point q = new Point(1, 2, 8);
        Point r = new Point(1, 2, 12);
        priorityQueue.add(p);
        priorityQueue.add(q);
        priorityQueue.add(r);
        System.out.println(priorityQueue.peek());
        r.distance = 7;
        System.out.println(priorityQueue.peek());
        HashSet<Point> hashSet = new HashSet<>();
        hashSet.add(p);
        System.out.println(hashSet.contains(p));

    }
}

//    public int shortestDistanceA(int[][] maze, int[] publish, int[] destination) {
//        if (maze.length == 0 || maze[0].length == 0) return -1;
//        int m = maze.length, n = maze[0].length;
//        int[][] dist = new int[m][n];
//        boolean[][] visited = new boolean[m][n];
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>(m, (i1, i2)->{
//            return i1[2]-i2[2];
//        });
//        queue.offer(new int[]{publish[0], publish[1], 0});
//        while (!queue.isEmpty()) {
//            int[] node = queue.poll();
//            if (visited[node[0]][node[1]]) continue;
//            if (node[0] == destination[0] && node[1] == destination[1]) return node[2];
//            visited[node[0]][node[1]] = true;
//
//            for (int[] dir: dirs) {
//                int x = node[0];
//                int y = node[1];
//                int step = node[2];
//                while (x+dir[0] >= 0 && x+dir[0] < m && y+dir[1] >= 0 && y+dir[1] < n && maze[x+dir[0]][y+dir[1]] != 1) {
//                    x += dir[0];
//                    y += dir[1];
//                    step++;
//                }
//                if (visited[x][y]) continue;
//                if (dist[x][y] == 0 || dist[x][y] > step) {
//                    dist[x][y] = step;
//                    queue.offer(new int[]{x,y,step});
//                }
//            }
//        }
//        return -1;
//    }
//}
