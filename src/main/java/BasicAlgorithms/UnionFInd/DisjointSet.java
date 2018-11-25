package BasicAlgorithms.UnionFInd;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 12/10/17.
 */
//public class DisjointSet {
//    int count;
//    private Map<Long,Node> map = new HashMap<>();
//    private class Node{
//        long data;
//        Node parent;
//        int rank;
//    }
//    public void makeSet(long data){
//        count++;
//        Node node = new Node();
//        node.data = data;
//        node.parent = node;
//        node.rank = 0;
//        map.put(data,node);
//    }
//
//    public boolean union(long data1,long data2){
//        Node node1 = map.get(data1);
//        Node node2 = map.get(data2);
//
//        if(node1 == null || node2 == null){
//            return false;
//        }
//        Node parent1 = findSet(node1);
//        Node parent2 = findSet(node2);
//
//        if(parent1 == parent2){
//            return false;
//        }
//        if(parent1.rank<parent2.rank){
//            parent1.parent = parent2;
//        }
//        else if(parent2.rank<parent1.rank){
//            parent2.parent = parent1;
//        }
//        else {
//            parent2.parent = parent1;
//            parent1.rank = parent1.rank+1;
//        }
//        count--;
//        System.out.println("count "+count);
//        return true;
//    }
//    public boolean connected(long data1,long data2){
//        Node node1 = map.get(data1);
//        Node node2 = map.get(data2);
//
//        if(node1 == null || node2 == null){
//            return false;
//        }
//        Node parent1 = findSet(node1);
//        Node parent2 = findSet(node2);
//        if(parent1 == parent2){
//            return true;
//        }
//        return false;
//    }
//
//    private Node findSet(Node node1) {
//        Node parent= node1.parent;
//        if(parent == node1){
//            return parent;
//        }
//        node1.parent = findSet(node1.parent);
//        return node1.parent;
//    }
//    public Node findSet(long x){
//        Node node = map.get(x);
//        if(node == null){
//            return null;
//        }
//        else {
//            return findSet(node);
//        }
//    }
//    public int getCount(){
//        return count;
//    }
//}
// disjoint set make node and hashmap of
    //  koi value mein insert karna hu inside i create node of that type and put mapping
    // in the hashmap
    //
public class DisjointSet<T> {
    Map<T,Node> map = new HashMap<>();
    int count;
    private class Node<T>{
        T data;
        Node parent;
        int rank;
    }
    public void makeset(T data){
        Node<T> node = new Node<>();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        count++;
        map.put(data,node);
    }
    public Node<T> findset(T data){
        Node<T> node1 = map.get(data);
        if(node1 == null){
            return null;
        }
        Node<T> parent = findParent(node1);
        return parent;
    }
    public T findsetid(T data){
        Node<T> node1 = map.get(data);
        if(node1 == null){
            return null;
        }
        Node<T> parent = findParent(node1);
        return parent.data;
    }

    private Node findParent(Node node1) {
        Node parent = node1.parent;
        if(parent == node1){
            return parent;
        }
        node1.parent = findParent(parent);
        return node1.parent;
    }
    public boolean isConnected(T data1, T data2){
        Node<T> parent1 = findset(data1);
        Node<T> parent2 = findset(data2);
        if(parent1 == parent2){
            return true;
        }
        return false;
    }
    public boolean Union(T data1, T data2){
        Node<T> parent1 = findset(data1);
        Node<T> parent2 = findset(data2);
        if(parent1 == parent2){
            return false;
        }

        if(parent1.rank<parent2.rank){
            parent1.parent = parent2;
        }
        else if(parent2.rank>parent1.rank){
            parent2.parent = parent1;
        }
        else {
            parent1.parent = parent2;
            parent2.rank = parent2.rank+1;
        }
        count--;
        return true;
    }
    public int getCount(){
        return count;
    }
}