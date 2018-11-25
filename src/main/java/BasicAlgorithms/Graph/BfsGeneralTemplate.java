package BasicAlgorithms.Graph;

import java.util.List;
import java.util.Queue;

import java.util.*;
/**
 * Created by hadoop on 16/10/17.
 */
public class BfsGeneralTemplate {
    int INFINITY = Integer.MAX_VALUE;
    boolean [] marked ;
    int []edgeTo;
    int []distTo;
    private List<Integer>[] adj;
    int source ;

    public BfsGeneralTemplate(Graph graph,int s){
        marked = new boolean[graph.V()];
        distTo = new int[graph.V()];
        edgeTo = new int[graph.V()];
        source = s;
        bfs(graph,s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        for(int v=0;v<graph.V();v++){
            distTo[v] = INFINITY;
        }
        distTo[s] = 0;
        marked[s] =true;
        queue.add(s);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for(int w:graph.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;
                    // visited means yes it is reachable from source
                    // root
                    // how much distance that is in distance map
                    marked[w] = true;
                    distTo[w] = distTo[v]+1;
                    queue.add(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public int distTo(int v){
        return distTo[v];
    }
    public Iterable<Integer> path(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int x = v;
        while (x!=source){
            stack.add(x);
            x = edgeTo[x];
        }
        stack.push(x);
        return stack;
    }
}
