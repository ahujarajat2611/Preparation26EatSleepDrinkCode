package BasicAlgorithms.MyGraph;

/**
 * Created by hadoop on 21/10/17.
 */
import java.util.*;
import java.util.Queue;
public class MinimalHeigtTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();

        // to find miinum height we are traversing BFS from the leaves nodes .. all at once
        // BFS from multiple sources and meeting at one location ...
        // when number of nodes are less than 2 ...
        // kind of finding middle point ... shortest distance .....
        // think of doing BFS from multiple sourcces
        for(int i=0;i<n;i++){
            graph.put(i,new HashSet<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> startNodeLeaves = new LinkedList<>();
        for(int i=0;i<n;i++){
            // means degree is 1
            if(graph.get(i).size() == 1){
                startNodeLeaves.add(i);
            }
        }

        // we will publish BFS from all leaves nodes ...
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean []visited = new boolean[n];
        for(Integer v: startNodeLeaves){
            queue.add(v);
          //  visited[v] = true;
        }
        while (queue.size()>2){
            int polled = queue.poll();
            for(int v:graph.get(polled)) {
                graph.get(v).remove(polled);
                if(graph.get(v).size() == 1){
                    queue.add(v);
                }
            }
        }
        return new LinkedList<>(queue);

    }
}