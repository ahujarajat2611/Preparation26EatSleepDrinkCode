package BasicAlgorithms.MyGraph;

/**
 * Created by hadoop on 19/10/17.
 */
public class KosarajuSharirSCC {
    private boolean [] marked;
    private int []id;
    private int count;

    public KosarajuSharirSCC(Digraph g){
        marked = new boolean[g.getV()];
        id = new int[g.getV()];
        DepthFirstSearchOrders depthFirstSearchOrders = new DepthFirstSearchOrders(g.reverse());

        for(int x:depthFirstSearchOrders.reversePostOrder()){
            if(!marked[x]){
                dfs(g,x);
                count++;
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,v);
            }
        }
    }
    // Strongly connected components
    public int getCount() {
        return count;
    }
}
