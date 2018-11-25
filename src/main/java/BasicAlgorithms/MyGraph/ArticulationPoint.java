package BasicAlgorithms.MyGraph;

/**
 * Created by hadoop on 19/10/17.
 */
public class ArticulationPoint {
    boolean []marked;
    int []pre;
    int counter;
    int []low;
    boolean[] isarticulationpoint;
    int children;
    ArticulationPoint(Graph g){
        marked = new boolean[g.getV()];
        pre = new int[g.getV()];
        low = new int[g.getV()];
        isarticulationpoint = new boolean[g.getV()];
        for(int i=0;i<g.getV();i++){
            if(!marked[i]){
                dfs(g,i,i);
            }
        }
    }

    private void dfs(Graph g, int u, int v) {
        marked[v] = true;
        pre[v] = counter++;
        low[v] = pre[v];
        for(int w:g.adj(v)){
            if(!marked[w]){
                children++;
                dfs(g,v,w);
                low[v] = Math.min(low[v],low[w]);

                if(low[w]<pre[v] && u!=v){
                    System.out.println("all okay v is not artculationpiint");
                }

                else {
                    isarticulationpoint[v] = true;
                }

            }
            else if(w!=u){
                low[v] = Math.min(low[v],pre[w]);
            }
        }
        if(u == v && children>1){
            isarticulationpoint[u] = true;
        }


    }

}
