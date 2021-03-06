package BasicAlgorithms.MyGraph;

import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
public class Digraph {
    // number of nodes
    private int V;
    // number of edges
    private int E;
    private Bag<Integer>[]adj;
    int []indegree;
    public Digraph(int V){
        //graph of V number of nodes
        this.V = V;
        // o edge at publish
        this.E = 0;
        // not required as such
        adj = (Bag<Integer>[])new Bag[V];
        indegree = new int[V];

    }
    Digraph(Digraph g){
        this.E = g.E;
        this.V = g.V;
        adj = new Bag[this.V];
        for(int i=0;i<V;i++){
            Stack<Integer> stack = new Stack<>();
            for(int x:g.adj(i)){
                stack.push(x);
            }
            for(int w:stack){
                // very imp pay attention to it
                // what we are doing is that
                //adding elemetnts to adjacency list of new cloned graph
                // get the bag of each element and clone it as the other bag of another graph
                // very imp
                // we could have called ad edge but add edge would have added
                // each elemtnt twice
                // so better to add here
                adj[i].add(w);
            }
        }

    }
    // In in we create scanner object out of all possible streams
    // be it socket sysout file //
    // any sorts of stream abstractions
    public Digraph(In input){
        this.V = input.readInt();
        indegree = new int[V];
        adj = (Bag<Integer>[])new Bag[V];
        // initliase adj list
        for(int i=0;i<V;i++){
            adj[i] = new Bag<Integer>();
        }

        // local edges
        int E = input.readInt();

        for(int i=0;i<this.E;i++){
            // get first node of edge
            int v = input.readInt();
            // second node
            int w = input.readInt();
            addEdge(v,w);
        }

    }

    private void addEdge(int v, int w) {
        // we keep incrementing number of edges as well
        // since its a undirected graph so we need to add aedges in both
        // the adjecency list
        this.E++;
        adj[v].add(w);
        indegree[w]++;
       //  for directed this is not required adj[w].add(v);
    }

    // outdegree simple length of adjaceny list
    // indegree we calculte while adding aedges
    public int outDegree(int v){
        return adj[v].size();
    }
    public int indegree(int v){
        return indegree[v];
    }
    // since iterable is superclass of bag thats why
    // we could have retured bag itself
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Bag<Integer>[] getAdj() {
        return adj;
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
}
