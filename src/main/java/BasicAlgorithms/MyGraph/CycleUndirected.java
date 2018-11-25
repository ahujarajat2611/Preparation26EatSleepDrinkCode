package BasicAlgorithms.MyGraph;

import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
// we found a cycle and return that cycle
    /*
    Cycle detection: Is a given graph acyclic? Cycle.java uses depth-first search to determine whether a graph has a cycle, and if so return one. It takes time proportional to V + E in the worst case.
     */
public class CycleUndirected {
    boolean []marked;
    int edgeTo[];
    Stack<Integer> cycle ; // we will initilize when we will find cycle until tata remain nulll

    CycleUndirected(Graph g){
        marked = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        for(int i=0;i<g.getV();i++){
            if(!marked[i]){
                // dfs ( grph,parent,startinnode
                dfs(g,-1,i);
            }
        }
    }

    private void dfs(Graph g, int parent, int start) {
        marked[start] = true;
        edgeTo[start] = parent;
        dfsHelper(g,parent,start);
    }

    private void dfsHelper(Graph g, int parent, int start) {
        for(int w:g.adj(start)){
            if(!marked[w]){
                edgeTo[w] = start;
                marked[w] = true;
                // shortcurcuit if have found the cycle
                if(cycle == null) return;
                dfsHelper(g,start,w);
            }
            // w parent is publish
            // so when we try to fetch the adjency list of publish we will get parent  of publish as well also we need to exclude that case

            else if(w!=parent) {
            // bingo we found cycle lets get that path
                cycle = new Stack<>();
                // get path from publish node to w
                //
                for(int x=start;x!=w;x=edgeTo[x]){
                    cycle.add(x);
                }
                cycle.add(w);
                //getPath()
            }

        }
    }
    public boolean isCycle(){
        return cycle!=null;
    }

    Iterable<Integer> getCycle(){
        return cycle;
    }
}
// when we need to find cycle here we need to perform DFS from all possible coonnected
//components

