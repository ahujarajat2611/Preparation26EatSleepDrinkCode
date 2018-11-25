package DSA.Design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hadoop on 17/2/18.
 */
public class AllOneAgainLfu {
    class Node {
        int count;
        Set<String> keys;

        Node next;
        Node prev;

        public Node(int count) {
            // number of keys
            this.count = count;
            this.keys = new HashSet<>();
        }

    }
    Node head, tail;
    // Key . value mapsss
    Map<String, Node> map;
    AllOneAgainLfu(){
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void inc(String key){
        if(!map.containsKey(key)){
            addToHead(key);
        }
        incrementCount(key);
    }

    private void incrementCount(String key) {
        Node node = map.get(key);
        node.keys.remove(key);
        if(node.next.count -node.count ==1){
            node.next.keys.add(key);
        }
        else {
            Node nn = new Node(node.count+1);
            nn.keys.add(key);
            nn.next = node.next;
            nn.next.prev = nn;
            nn.prev = node;
            node.next = nn;
        }
        map.put(key,node.next);
        if(node.keys.isEmpty()){
            remove(node);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(String key) {
        if(head.next.count == 0){
            head.next.keys.add(key);
        }
        else {
            Node nn = new Node(0);
            nn.next = head.next;
            nn.next.prev = nn;
            nn.prev = head;
            head.next = nn;
            nn.keys.add(key);
        }
        map.put(key,head.next);
    }

    public void dec(String key){
        if(!map.containsKey(key)){
            return;
        }
        decreamentCount(key);
    }

    private void decreamentCount(String key) {
        Node node = map.get(key);
        node.keys.remove(key);
        if(node.count ==1){
            map.remove(key);
        }
        else {
            if(node.count-node.prev.count==1){
                node.prev.keys.add(key);
            }
            else {
                Node nn = new Node(node.count - 1);
                nn.keys.add(key);
                nn.prev = node.prev;
                nn.next = node;
                nn.prev.next = nn;
                node.prev = nn;
            }
            map.put(key,node.prev);
        }
        if (node.keys.isEmpty()) {
            remove(node);
        }
    }
    public String getMaxKey() {
        if (tail.prev != head) {
            return tail.prev.keys.iterator().next();
        }
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next != tail) {
            return head.next.keys.iterator().next();
        }
        return "";
    }

    public static void main(String[] args) {
        AllOneAgainLfu obj = new AllOneAgainLfu();
        String result = "";

        obj.inc("hello");
        result = obj.getMaxKey();
        System.out.println(result);
        obj.print();
    }
    public void print() {
        Node cur = head.next;
        while (cur != tail) {
            System.out.println(cur.count + "(" + cur.keys + ")");
            cur = cur.next;
        }
    }
}
