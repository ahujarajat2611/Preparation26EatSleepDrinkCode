package BasicAlgorithms.MyGraph.PracticeGraph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by hadoop on 20/10/17.
 */
public class EulerDirectedGraph {
    private int V;
    LinkedList<Integer>[] adj;
    int[] in;

    EulerDirectedGraph(int v) {
        this.V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
        in = new int[this.V];
    }

    public void addEdge(int v, int w) {
        // Directed Graph
        adj[v].add(w);
        in[w]++;
    }

    EulerDirectedGraph transpose() {
        EulerDirectedGraph eulerDirectedGraph = new EulerDirectedGraph(this.V);
        // get current graph adjacnecy list
        LinkedList<Integer>[] adj = this.adj;
        LinkedList<Integer>[] transPose = new LinkedList[this.V];

        int[] in = new int[this.V];
        for (int i = 0; i < this.V; i++) {
            transPose[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < V; i++) {
            for (int node : adj[i]) {
                transPose[node].add(i);
                in[i]++;
            }
        }
        eulerDirectedGraph.adj = transPose;
        eulerDirectedGraph.in = in;
        return eulerDirectedGraph;
    }

    public boolean isSC() {

        boolean marked[] = new boolean[V];
        dfs(0, marked);
        for (int i = 0; i < V; i++) {
            if (!marked[i]) {
                return false;
            }
        }
        Arrays.fill(marked, false);

        EulerDirectedGraph transposedGraph = transpose();
        transposedGraph.dfs(0, marked);
        for (int i = 0; i < V; i++) {
            if (!marked[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int v, boolean[] marked) {
        marked[v] = true;
        for (int w : adj[v]) {
            if (!marked[w])
                dfs(w, marked);
        }
    }

    Boolean isEulerianCycle(){
        if(isSC() == false){
            return false;
        }
        
        for(int i=0;i<V;i++){
            int indegree = in[i];
            int outdegree = adj[i].size();
            if(indegree!=outdegree){
                // simpel for every indegree there has to be outdegree for corsisng
                // each edge exactly one 
                return false;
            }
        }
        return true;
        // check for indegree ..
        // indegree of all nodes has to be same as outgoing degree
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        EulerDirectedGraph g = new EulerDirectedGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        if (g.isEulerianCycle())
            System.out.println("Given directed graph is eulerian ");
        else
            System.out.println("Given directed graph is NOT eulerian ");
    }
}
