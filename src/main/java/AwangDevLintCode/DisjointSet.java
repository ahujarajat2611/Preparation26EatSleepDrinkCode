package AwangDevLintCode;

import java.util.*;
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