package BasicAlgorithms.Graph;

import java.util.*;
/**
 * Created by hadoop on 27/1/18.
 */
public class CloneGraphMine {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode,UndirectedGraphNode> cloneMap = new HashMap<>();
        dfs(cloneMap,node);
        return cloneMap.get(node);
    }
    private void dfs(Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap, UndirectedGraphNode node) {
        if(node == null){
            return;
        }
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        cloneMap.put(node,cloned);
        for(UndirectedGraphNode child:node.neighbors){
            if(cloneMap.containsKey(child)){ // to stop recurrssion
                cloneMap.get(node).neighbors.add(cloneMap.get(child));
            }
            else{
                dfs(cloneMap,child);
                cloneMap.get(node).neighbors.add(cloneMap.get(child));
            }
        }
    }
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}
