package BasicAlgorithms.MyGraph;

/**
 * Created by hadoop on 19/10/17.
 */
// we can use dfs to count connected components
    // also size in reach connected component
    // remember no. of nodes in DFS application
    // just use that strait forward
    // in short we need to perform DFS from nodes one by one
public class ConnectedComponents {
    boolean [] marked;
    int [] id ; // all nodes will assigned to either of connected component id[node] = connectedcomponenstid
    int [] size; // size[connectedCoponent] will return size of each component
    int connectedComponents; // at the end it will return no. of connected componesnts
    // note dfs has always one starting point
    // inn all questions of dfs, u need to figure out the startting point
    public ConnectedComponents(Graph g){

        marked = new boolean[g.getV()];
        /// assign different id to each of the node int he beginning
        id = new int[g.getV()];
        size = new int[g.getV()];
        for(int i=0;i<g.getV();i++){

            marked[i] = false;
            id[i] = i;
            size[i] = 0;
        }
        for(int i=0;i<g.getV();i++) {
            if(!marked[i]) {
                dfs(g, i);
                connectedComponents++;
            }
        }
    }
// dfs from node v
    // two types of dfs possible
    // before you call mark it
    // after yuou call mark it

    // i prefer to mark befoe the call so always i need helper function to
    // mark the starting node before i make call to actual dfs funciton

    private void dfs(Graph g, int s) {
        marked[s] = true;
        // count tells the number of vertex connected to source vertex
        id[s] = connectedComponents;
        size[connectedComponents] = size[connectedComponents] +1;
        dfsHelper(g,s);
    }
    private void dfsHelper(Graph g, int v){
        for(int w:g.adj(v)){
            if(!marked[w]){
                marked[w] = true;
                id[w] = connectedComponents;
                size[connectedComponents] = size[connectedComponents] +1;
                dfsHelper(g,w);
            }
        }
    }

    public int getConnectedComponents() {
        return connectedComponents;
    }
}
