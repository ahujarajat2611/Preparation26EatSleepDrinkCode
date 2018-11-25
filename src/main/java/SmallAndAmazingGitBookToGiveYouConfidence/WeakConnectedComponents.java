package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 19/9/17.
 */
public class WeakConnectedComponents {
    DisjointSet disjointSet = new DisjointSet();

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<>();
        for(DirectedGraphNode node:nodes){
            disjointSet.makeSet(node.label);
        }

        for(DirectedGraphNode parent:nodes){
            for(DirectedGraphNode child:parent.neighbors){
                disjointSet.union(parent.label,child.label);
            }
        }
        Map<Long,List<Long>> list = new HashMap<>();

        for(DirectedGraphNode node:nodes){
            long parent = disjointSet.findSet(node.label);
            if(list.containsKey(parent)){
                list.get(parent).add(node.label);
            }
            else {
                List <Long> list1 = new ArrayList<>();
                list1.add(node.label);
                list.put(parent,list1);
            }
        }
        for(List l:list.values()){
            result.add(l);
        }
    return result;
    }
    private  class DirectedGraphNode {
        long label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
}
