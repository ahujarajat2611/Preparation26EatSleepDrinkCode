package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
public class LRUCache {
    private class Node
    {
        Node prev;
        Node next;
        int key;
        int val;
        public Node (int key, int val)
        {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer ,Node> hm = new HashMap<Integer ,Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
     
    public int get(int key) {
        if (!hm.containsKey(key))
            return -1;
        Node curr = hm.get(key);
        // thats how you delete node
        // once you get access of that node !!
        // you can easily delete ndoe !!
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        MoveToTail(curr);
        return hm.get(key).val;
    }
     
    public void set(int key, int value) {
        if (get(key) != -1)
        {
            hm.get(key).val = value;
            return;
        }
        if (hm.size() == capacity)
        {
            hm.remove(head.next.key);
            // thats howo you delete node at head
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node newNode = new Node(key, value);
        hm.put(key, newNode);
        MoveToTail(newNode);
    }
    private void MoveToTail(Node node)
    {
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev.next = node;
    }
}