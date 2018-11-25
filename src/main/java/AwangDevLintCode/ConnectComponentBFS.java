package AwangDevLintCode;
import java.util.*;
/**
 * Created by hadoop on 4/2/18.
 */
/*
 /*
Find the number connected component in the undirected graph.
Each node in the graph contains a label and a list of its neighbors.
(a connected component (or just component) of an undirected graph is a subgraph in which
    any two vertices are connected to each other by paths,
and which is connected to no additional vertices in the supergraph.)

Example
Given graph:

A------B  C
 \     |  |
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

Note
Tags Expand
Breadth First Search

 */

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

/*
OPTS: 11.07.2015
Try to use ae map<Integer, false> to mark the nodes. Then do a BFS with queue
1. Mark each node in map.
2. BFS each node
3. Whenver one node is checked, mark it check
*/

class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class ConnectComponentBFS {
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return rst;
        }

        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (UndirectedGraphNode node : nodes) {
            map.put(node.label, false);
        }

        for (UndirectedGraphNode node : nodes) {
            if (!map.get(node.label)) {
                bfs(rst, node, map);
            }
        }
        return rst;
    }

    public void bfs(List<List<Integer>> rst, UndirectedGraphNode node, HashMap<Integer, Boolean> map) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        List<Integer> list = new ArrayList<Integer>();
        queue.add(node);
        map.put(node.label, true);
        // before you push to queueue make it visited !!!!
        // thats it !!
        UndirectedGraphNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            list.add(temp.label);
            ///polling order nothing but visiting order
            ///so once we have polling order thats the connected commenenet
            ///very nicely done then and there itself
            ///this trick needs to be used if we need actually components not just numbver !!!
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                if (!map.get(neighbor.label)) {
                    queue.offer(neighbor);
                    map.put(neighbor.label, true);
                }
            }
        }
        Collections.sort(list);
        rst.add(list);
    }
}
