package BasicAlgorithms.MyGraph;

/**
 * Created by hadoop on 19/10/17.
 */
public class DepthFirstSearch {
    // first thing in dfs is marked
    boolean [] marked;
    // note dfs has always one starting point
    // inn all questions of dfs, u need to figure out the startting point
    int count;
    public DepthFirstSearch(Graph g, int s){
        // init the visited set
        marked = new boolean[g.getV()];
        dfs(g,s);
    }
// dfs from node v
    // two types of dfs possible
    // before you call mark it
    // after yuou call mark it

    // i prefer to mark befoe the call so always i need helper function to
    // mark the starting node before i make call to actual dfs funciton
    //
    private void dfs(Graph g, int s) {
        marked[s] = true;
        // count tells the number of vertex connected to source vertex
        count++;
        dfsHelper(g,s);
    }
    private void dfsHelper(Graph g, int v){
        for(int w:g.adj(v)){
            if(!marked[w]){
                marked[w] = true;
                count++;
                dfsHelper(g,w);
            }
        }
    }

    public int getCount() {
        return count;
    }
}
