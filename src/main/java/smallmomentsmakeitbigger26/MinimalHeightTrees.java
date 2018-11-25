package smallmomentsmakeitbigger26;
import java.util.*;

/**
 * Created by hadoop on 14/12/17.
 */


public class MinimalHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        // I deal with such problemms in different way
        for (int i = 0; i < n; i++) {
            graph.put(i, new Node(i));
        }

        for (int[] edge : edges) {
            // undirected edge
            graph.get(edge[0]).neighbors.add(graph.get(edge[1]));
            graph.get(edge[1]).neighbors.add(graph.get(edge[0]));
            // adding degrees of both outgoing incomeing
            /// since here it is undireccted graph
            graph.get(edge[0]).degree++;
            graph.get(edge[1]).degree++;
        }

        Queue<Node> queue = new LinkedList<>();
        for (int index : graph.keySet()) {
            // since we are condering all ingegreess
            // we can add check for 1 instea of 0
            if (graph.get(index).degree == 1) {
                queue.offer(graph.get(index));
            }
        }
// keep iterating until we have  more than 2 nodes in the undireccted grapgh


        while (n > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node leaf = queue.poll();
                Node neighbor = leaf.neighbors.iterator().next();
                // since it is undirected and
                // either we create visited set of
                // removal from the neighbbbout
                // is the option
                // we could have used
                // visited metrics to get rid of removal
                // kind of thin
                // making sure we are not looping back ...
                neighbor.neighbors.remove(leaf);//
                // remove leaf from its neighbor's adj list
            //  remaining ndoes in graph would have root
                graph.remove(leaf.label);
                //remove leaf self
                n--;
                // removal node as n gets reduced
                // bit tricky problem it is
                if (--neighbor.degree == 1) {
                    queue.offer(neighbor);
                }
            }
        }

        return new ArrayList<>(graph.keySet());

    }
}

class Node {
    int label;
    int degree;
    Set<Node> neighbors;
    public Node(int index) {
        label = index;
        neighbors = new HashSet<>();
    }
}