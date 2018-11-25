package BasicAlgorithms.MyGraph;

/**
 * Created by hadoop on 19/10/17.
 */

/*
Bridge: A bridge (or cut-edge) is an edge whose deletion increases the number of connected components.
Equivalently, an edge is a bridge if and only if it is not contained in any cycle
. Bridge.java uses depth-first search to find time the bridges in a graph
. It takes time proportional to V + E in the worst case.
 */
public class Bridge {
    int bridges;
    int counter=0;
    boolean []marked;
    int []pre;
    int []low;
    Bridge(Graph g){
        marked = new boolean[g.getV()];
        pre = new int[g.getV()];
        low = new int[g.getV()];
        for(int i=0;i<g.getV();i++){
            if(!marked[i]){
                dfs(g,i,i);
            }
        }
    }

    private void dfs(Graph g, int u, int v) {
        marked[v] = true;
        pre[v]= counter++;
        low[v] = counter;

        for(int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,v,w);
                low[v] = Math.min(low[v],low[w]);
                if(low[w]<=pre[v]){
                    System.out.println("all okay ");
                }

                // in simply terms low[w]==pre[w] there is a bridge
                else {
                    bridges++;
                    System.out.println("w to v there is bridge");
                }
            }
            else if(w!=u){
                low[v] = Math.min(low[v],pre[w]);
            }
        }
    }
}
