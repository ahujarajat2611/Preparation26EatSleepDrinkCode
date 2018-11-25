package OldAttemptLearning.VideoLectures;//package VideoLectures;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * Created by hadoop on 28/8/17.
// */
//public class BreadthSearchPaths {
//    private static final int INFINITY = Integer.MAX_VALUE;
//    private boolean [] marked;
//    private  int [] edgeTo; // previous edge on shortest path from s to v
//    private int []distTo;
//
//    public BreadthSearchPaths(Graph<Integer> g,int s){
//        marked = new boolean[g.vertexes.size()];
//        distTo = new int[g.vertexes.size()];
//        edgeTo = new int[g.vertexes.size()];
//        bfs(g,s);
//    }
//
//    private void bfs(Graph<Integer> g, int s) {
//        Queue<Integer> queue = new LinkedList<>();
//        for( int v=0;v<g.vertexes.size();v++){
//            distTo[v] = INFINITY;
//        }
//        distTo[s] = 0;
//        marked[s] = true;
//        queue.add(s);
//        while (!queue.isEmpty()){
//            int v = queue.poll();
//            for( int w:)
//        }
//
//    }
//
//}
