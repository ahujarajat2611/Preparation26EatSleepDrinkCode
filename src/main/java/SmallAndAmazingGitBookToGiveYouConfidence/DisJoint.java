package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 19/9/17.
 */
public class DisJoint {
    private Map<Long,Node> map = new HashMap<>();
    private class Node{
        long data;
        Node parent;
        int rank;
    }
    public void makeSet(long data){
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent=node;
        map.put(data,node);
    }
    public boolean union(long data1,long data2){
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        if(parent1 == parent2){
            return false;
        }

        if(parent1.rank<parent2.rank){
            parent1.parent=parent2;
        }
        else if(parent2.rank>parent1.rank){
            parent2.parent = parent1;
        }
        else {
            parent2.parent = parent1;
            parent1.rank = parent1.rank+1;
        }
        return true;

    }

    private Node findSet(Node node1) {
        if(node1 == null){
            return null;
        }
        if(node1.parent!=node1) {
            node1.parent = findSet(node1.parent);
        }
        return node1;
    }
}
