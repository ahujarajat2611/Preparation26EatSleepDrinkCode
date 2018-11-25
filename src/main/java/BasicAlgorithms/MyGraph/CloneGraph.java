package BasicAlgorithms.MyGraph;
import java.util.*;

/**
 * Created by hadoop on 21/10/17.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hashMap = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        hashMap.put(node,root);
        dfsHelper(hashMap,root);
        return root;
    }

    private void dfsHelper(HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap, UndirectedGraphNode u) {

        for(UndirectedGraphNode v:u.neighbors){
            if(!hashMap.containsKey(v)){
                hashMap.put(v,new UndirectedGraphNode(v.label));
                dfsHelper(hashMap,v);
            }
            hashMap.get(u).neighbors.add(v);
        }
    }

    private class UndirectedGraphNode {
			      int label;
			      List<UndirectedGraphNode> neighbors;
			      UndirectedGraphNode(int x) {
			          label = x;
                      neighbors = new ArrayList<UndirectedGraphNode>();
			      }
    };
}
