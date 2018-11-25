package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashMap;

/**
 * Created by hadoop on 19/9/17.
 */
public class DisJointSetImpl {
    HashMap<Character,Node> rootMap = new HashMap<Character, Node>();
    private class Node{
        Node parent;
        int rank;
        Character data;
    }
    public void makeSet(Character data){
        Node node = new Node();
        node.parent = node;
        node.rank = 0;
        node.data = data;
        rootMap.put(data,node);
    }
    public boolean unionSet(Character data1,Character data2){
        Node node1 = rootMap.get(data1);
        Node node2 = rootMap.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        if(parent1 == parent2){
            return false;
        }
        if(parent1.rank <parent2.rank){
            parent1.parent = parent2;
        }
        else if(parent1.rank>parent2.rank){
            parent2.parent = parent1;
        }
        else {
            parent1.rank = parent1.rank+1;
            parent2.parent = parent1;
        }
        return true;

    }
    public Node findSet(Node node){
        Node parent = node.parent;
        if(parent!=node){
            node.parent = findSet(parent);
        }
        return parent;
    }
    public Character findSet(Character character){
        if(rootMap.containsKey(character)) {
            return findSet(rootMap.get(character)).data;
        }
        return null;
    }

    public static void main(String[] args) {
        DisJointSetImpl disJointSet = new DisJointSetImpl();

        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
        disJointSet.makeSet('a');
        disJointSet.makeSet('b');disJointSet.makeSet('c');disJointSet.makeSet('d');disJointSet.makeSet('e');
        disJointSet.makeSet('f');disJointSet.makeSet('g');
        disJointSet.unionSet('a','b');
        disJointSet.unionSet('b','c');
        disJointSet.unionSet('d','e');
        disJointSet.unionSet('f','g');
        System.out.println(disJointSet.findSet('e'));
    }
}
