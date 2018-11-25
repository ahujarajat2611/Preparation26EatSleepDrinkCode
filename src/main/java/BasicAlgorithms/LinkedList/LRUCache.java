package BasicAlgorithms.LinkedList;
import java.util.*;
public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node dummyHead;
    private Node dummyTail;
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.dummyHead = new Node(0, 0);
        this.dummyTail = new Node(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    public int get(int key) {
        Node target = map.get(key);
        if (target != null){
            target.prev.next = target.next;
            target.next.prev = target.prev;
            add_to_tail(target);
            return target.val;
        } else {
            return -1;
        }
    }
    public void set(int key, int value) {
        Node newNode = new Node(key, value);
        if (get(key) != -1){ // do not use map.get here
            map.get(key).val = value;
            return;
        }
        if (map.size() >= this.capacity){
            // so we want to have key field in Node class
            map.remove(dummyHead.next.key);
            remove_from_head();
        } 
        map.put(key, newNode);
        add_to_tail(newNode);
    }
    private void add_to_tail(Node current){
        dummyTail.prev.next = current;
        current.prev = dummyTail.prev;
        current.next = dummyTail;
        dummyTail.prev = current;
    }
    private void remove_from_head(){
        dummyHead.next = dummyHead.next.next;
        dummyHead.next.prev = dummyHead;
    }
}