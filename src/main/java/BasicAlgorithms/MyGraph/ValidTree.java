package BasicAlgorithms.MyGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 21/10/17.
 */
public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        // create graph
        // how would u create graph
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        for (int i=0;i<n;i++){
            graph.put(i,new HashSet<>());
        }
        for(int []edge:edges){
            // since undirected graph
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();

        boolean [] visited = new boolean[n];
        queue.add(0);
        while (!queue.isEmpty()){
            Integer v = queue.poll();
            if(visited[v]){ // means cycle is present
                return false;
            }
            for(Integer w:graph.get(v)){
                graph.get(w).remove(v); // whatttta  clasic approach
                queue.add(w);
                visited[w] = true;
            }
        }
        // all nodes should have visited ..
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
    }
}