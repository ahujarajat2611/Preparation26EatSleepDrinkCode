package AwangDevLintCode;

/**
 * Created by hadoop on 24/2/18.
 */
import java.util.*;
public class MinimalHeightTreesNew {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new Node(i));
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).neighbors.add(graph.get(edge[1]));
            graph.get(edge[1]).neighbors.add(graph.get(edge[0]));
            graph.get(edge[0]).degree++;
            graph.get(edge[1]).degree++;
        }

        Set<Integer> visited = new HashSet<Integer>();
        Queue<Node> queue = new LinkedList<>();
        for (int index : graph.keySet()) {
            if (graph.get(index).degree == 1) {
                queue.offer(graph.get(index));
                visited.add(index);
                n = n-visited.size();
            }
        }

        while (n > 2) {
            Node u = queue.poll();
            for(Node v: graph.get(u.label).neighbors){
                if(!visited.contains(v.label)){
                    if(--v.degree == 1){
                        visited.add(v.label);
                        n = n-1;
                        queue.add(v);
                    }

                }
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        for(Integer x:graph.keySet()){
            if(!visited.contains(x)){
                list.add(x);
            }
        }
        return list;
        // int size = queue.size();
        // for (int i = 0; i < size; i++) {
        //     Node leaf = queue.poll();
        //     Node neighbor = leaf.neighbors.iterator().next();
        //     neighbor.neighbors.remove(leaf);//remove leaf from its neighbor's adj list
        //  //   graph.remove(leaf.label);//remove leaf self
        //     n--;
        //     if (--neighbor.degree == 1) {
        //         queue.offer(neighbor);
        //     }
        // }

        //  return new ArrayList<>(graph.keySet());

    }
}

