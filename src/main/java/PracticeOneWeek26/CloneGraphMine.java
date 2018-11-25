package PracticeOneWeek26;

/**
 * Created by hadoop on 26/2/18.
 */
import java.util.*;
public class CloneGraphMine {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        if(node == null){
            return null;
        }
        dfsHelperMine(map,node);
        return map.get(node);
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
