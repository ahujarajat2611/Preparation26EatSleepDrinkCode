package BasicAlgorithms.MyGraph;

import java.util.Stack;
/*
Two-colorability: Can the vertices of a given graph be assigned one of two colors in such a way that no edge connects vertices of the same color? Bipartite.java uses depth-first search to determine whether a graph has a bipartition; if so, return one; if not, return an odd-length cycle. It takes time proportional to V + E in the worst case.
 */

/**
 * Created by hadoop on 19/10/17.
 */
// same as cycle just check for odd length cycle
    // if that exist means  you can remove that as well
public class Bipartitie {
    boolean []marked ;
    boolean []color; // kkeeping two colors but we can change as we go ahead
    Stack<Integer> cycle ; // keep it null until we find it
    int []edgeTo;
    boolean isBipartite;
    // if we wan to find that particular cycle
    Bipartitie(Graph g){
        marked = new boolean[g.getV()];
        color = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        for(int i=0;i<g.getV();i++){
            if(!marked[i]){
                dfs(g,i);
            }
        }
        // nedeed to this to find actual cycle
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        edgeTo[s] = -1;
        color[s] = true;
        dfsHelper(g,s);
    }

    private void dfsHelper(Graph g, int s) {

        for(int w:g.adj(s)){
            if(cycle!=null){
                return;
            }
            if(!marked[w]){
                color[w] = !color[s];
                marked[w] = true;
                edgeTo[w] = s;
            }
            // we are sure that parent would have different color so parent passing not requied
            else if( color[w] == color[s]){
                // we found cycle lets prin tit
                isBipartite = true;
                cycle = new Stack<>();
                cycle.add(w);
                for(int x=s;x!=w;x = edgeTo[x]){
                    cycle.add(x);
                }
                // if you wanto add repeating cycle node once again
                cycle.add(w);
            }
        }
    }

}
