package BasicAlgorithms.MyGraph;

import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
/*
Finding paths. It is easy to modify depth-first search to not only determine whether there exists a path between two given vertices but to find such a path (if one exists)
 */
public class DepthFirstSearchFindPaths {
    private boolean marked[];
    int[] edgeTo;
    int sourcevertex;

    // gIVEN GRAPH AND SOURCE VERTEX
    // the whole point is to find paths from source vertex
    //
    DepthFirstSearchFindPaths(Graph g, int s) {
        this.sourcevertex = s;
        marked = new boolean[g.getV()];
        edgeTo = new int[g.getV()];

    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        dfsHelper(g,v);
    }

    private void dfsHelper(Graph g, int v) {
        for(int w:g.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                marked[w] = true;
                dfsHelper(g,w);
            }
        }
    }
    // refeence point source vertex
    public boolean hasPathto(int v){
        return marked[v];
    }
    // asume it has path . kindly return that collection

    Iterable<Integer> pathTo(int v){
        Stack<Integer> path = new Stack<>();
        path.add(v);
        pathToHelper(v,path);
        path.add(this.sourcevertex);
        return path;
    }

    private void pathToHelper(int v,Stack<Integer> path) {
        if(edgeTo[v]!= this.sourcevertex){
            path.add(edgeTo[v]);
            pathToHelper(edgeTo[v],path);
        }
    }
    // rule of thumb if child is valid apply recursion
    // as we use this rechinique in dfs a lot // so why not dfs done this way only
    // makes thing easier
}