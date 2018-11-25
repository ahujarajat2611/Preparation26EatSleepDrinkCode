package SystemDesignCodes;


import java.util.HashMap;

/**
 * Created by hadoop on 7/10/17.
 */
/*
Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Tags: Design

*/
/*
It looks like we need to do some design, according to (http://www.cnblogs.com/yuzhangcmu/p/4113462.html). Though, the solution's concept is quite similar as attempt1.

1. The design uses HashMap, and 2-way LinkedList. Map<key, LinkNode>
2. Use two dummy node: head and tail. When add/remove nodes, we are add/remove nodes in between head and tail.
	So. head.next is our real 1st element
	andd tail.pre is our real last element

Note:
Be careful: when removing a node due to capacity issue, remember to remove both 1st node(head.next) and the corresponding entry in the map: map.remove(head.next.key)
*/

//Use double linked list to store value.
//Store key in hashmap<key, node> to find node easily
//Functions: insert in front, remove node,
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
