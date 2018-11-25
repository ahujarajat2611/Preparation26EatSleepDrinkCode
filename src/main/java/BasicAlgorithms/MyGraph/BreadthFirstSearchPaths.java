package BasicAlgorithms.MyGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
public class BreadthFirstSearchPaths {
    int INFINITY = Integer.MAX_VALUE;
    boolean[] marked;
    int[] edgeTo;
    int[] distTo;

    public BreadthFirstSearchPaths(Graph g, int s) {
        marked = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        distTo = new int[g.getV()];
        for (int i = 0; i < g.getV(); i++) {
            distTo[i] = INFINITY;
        }
        // source distance always zero
        distTo[s] = 0;
        // after initialzation call bfs
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < g.getV(); i++) {
            distTo[i] = INFINITY;
        }
        // first 3 thinsg initilaze
        // then source properties set
        distTo[s] = 0;
        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    // if sometimes we need to perfomr bfs from so many places we can perform bfs from multiple sources at once
    private void bfs(Graph g, Iterable<Integer> sources) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < g.getV(); i++) {
            distTo[i] = INFINITY;
        }
        // first 3 thinsg initilaze
        // then source properties set
        // thats all we need to do
        for (int s : sources) {
            distTo[s] = 0;
            marked[s] = true;
            queue.add(s);
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    // has path means from starting point fixeddddddd which is source of BFS
    public boolean hasPathTo(int v) {
        return marked[v] ;
    }
    public int disTo (int v){
        return distTo[v];
    }
    public Iterable<Integer> pathTo(int v){
        Stack<Integer> stack = new Stack<>();
        stack.add(v);
        pathToHelper(v,stack);
        return stack;
    }
    //it is nothing but DFS from backwards thats allllll it is so think abt dfs
    void pathToHelper(int v,Stack<Integer> stack){
        if(distTo[v]!=0){
            stack.push(edgeTo[v]);
            pathToHelper(edgeTo[v],stack);
        }
        else {
            //at last add the source as well
            stack.add(v);
        }
    }
}