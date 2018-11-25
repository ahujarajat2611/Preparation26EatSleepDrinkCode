package BasicAlgorithms.Graph;

import java.util.*;
import java.util.Queue;

/**
 * Created by hadoop on 6/1/18.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(copyNode.label, copyNode);
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode n: current.neighbors){
                // only when the n node has not been seen yet, it needs to be copied and we should add n to queue
                if (!map.containsKey(n.label)){
                    UndirectedGraphNode copyN = new UndirectedGraphNode(n.label);
                    map.get(current.label).neighbors.add(copyN);
                    queue.offer(n);
                    map.put(copyN.label, copyN);
                } else {
                    UndirectedGraphNode findN = map.get(n.label);
                    map.get(current.label).neighbors.add(findN);
                }
            }
        }
        return copyNode;
    }
    class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
}
