package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 8/12/17.
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


    public UndirectedGraphNode cloneGraphMine(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hashMap = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        hashMap.put(node,root);
        dfsHelper(hashMap,root);
        return root;
    }

    private void dfsHelperMine(HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap, UndirectedGraphNode u) {

        if(!hashMap.containsKey(u)){
            hashMap.put(u,new UndirectedGraphNode(u.label));
        }
        for(UndirectedGraphNode v:u.neighbors){
            if(!hashMap.containsKey(v)){
                hashMap.put(v,new UndirectedGraphNode(v.label));
                hashMap.get(u).neighbors.add(hashMap.get(v));
                dfsHelperMine(hashMap,v);
            }
            else {
                hashMap.get(u).neighbors.add(hashMap.get(v));
            }
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
