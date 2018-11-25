package SystemDesignCodes;

import java.util.HashMap;

/**
 * Created by hadoop on 22/10/17.
 */
public class MyLruCache<K,V> {
    Node<K,V> head;
    Node<K,V> tail;
    int capacity;
    HashMap<K,Node<K,V>> hashMap = new HashMap<>();
    MyLruCache(int capacity){
        head = new Node<K,V>();
        tail = new Node<K,V>();
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
        head.previous = tail;
        tail.next = head;
    }

    private class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;
        Node<K,V> previous;
        Node(K key,V value){
            this.key = key;
            this.value = value;
        }
        Node(){

        }
    }

    V get(K key){
        if(hashMap.containsKey(key)){
            Node<K,V> node = hashMap.get(key);
            moveToHead(node);
            return node.value;
        }
        else {
            return null;
        }
    }

    private void moveToHead(Node<K, V> node) {
        remove(node);
        insertAtHead(node);
    }

    private void remove(Node<K, V> node) {
        node.next.previous = node.previous;
        node.previous.next = node.next;
    }
    private void  insertAtHead(Node<K,V> node){
        Node<K,V> oldHead = head.next;
        head.next = node;
        node.next = oldHead;
        oldHead.previous = node;
    }
    void put(K key,V value){
        Node<K,V> node = hashMap.get(key);
        if(node!=null){
            node.value = value;
            moveToHead(node);
            return;
        }
        else {
         // Here movetohead nope inseatd only insert since its the first entrying in this cache
            // move to head required only in get method or in put that particular node already exists ...
            if(hashMap.size()>=capacity){
                // remove  from the tail...
                Node tobeRemoved = tail.previous;
                remove(tobeRemoved);
                hashMap.remove(tobeRemoved.key);
            }

            node = new Node<K,V>(key,value);
            insertAtHead(node);
            hashMap.put(key,node);
            return;
        }

    }

}
