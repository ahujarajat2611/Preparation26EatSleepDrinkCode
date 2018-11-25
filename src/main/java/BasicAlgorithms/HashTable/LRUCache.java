package BasicAlgorithms.HashTable;

import java.util.*;
public class LRUCache {
    class DoubleLinkedListNode {
        int key, val;
        DoubleLinkedListNode next,prev;
        public DoubleLinkedListNode(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }
    public int capacity;
    public HashMap<Integer, DoubleLinkedListNode> map;
    public DoubleLinkedListNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, DoubleLinkedListNode>();
        this.head = new DoubleLinkedListNode(-1, -1);
        this.tail = new DoubleLinkedListNode(-1, -1);
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            moveToHead(map.get(key));
        } else {
            DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
            if (map.size() >= this.capacity) {
                DoubleLinkedListNode rm = tail.prev;
                remove(rm);
                map.remove(rm.key);
            }
            insertHead(node);
            map.put(key, node);
        }
    }

    public void moveToHead(DoubleLinkedListNode node) {
        remove(node);
        insertHead(node);
    }
    
    //Helper functions
    public void insertHead(DoubleLinkedListNode node) {
        DoubleLinkedListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public void remove(DoubleLinkedListNode node) {
        DoubleLinkedListNode front = node.prev;
        DoubleLinkedListNode end = node.next;
        front.next = end;
        end.prev = front;
    }  
}