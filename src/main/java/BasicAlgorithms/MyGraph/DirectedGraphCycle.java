package BasicAlgorithms.MyGraph;

import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
public class DirectedGraphCycle {
    Stack<Integer> cycle ;
    boolean marked[];
    boolean onstack[];
    int edgeTo[];
    DirectedGraphCycle(Digraph g){
        marked = new boolean[g.getV()];
        onstack = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        for(int v=0;v<g.getV();v++){
            if(!marked[v]) {
                dfs(g, v);
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        onstack[v] = true;
        for(int w:g.adj(v)){

            if(cycle!=null){
                return;
            }
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g,w);
            }
            else if(onstack[w] = true){
                cycle = new Stack<>();
                for(int x=v;x!=w;x=edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
        onstack[v] = false;
    }
}
