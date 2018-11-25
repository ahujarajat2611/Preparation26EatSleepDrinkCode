package BasicAlgorithms.Graph;

import java.util.Iterator;

/**
 * Created by hadoop on 19/10/17.
 */
// all classs extend iterable which exposse iterator iterface
public class Queue<Item> implements Iterable<Item> {

    Node<Item> first;
    Node<Item> last;
    int n=0;
    private class Node<Item>{
        Node<Item> next;
        Item item;
    }

    Queue(){
        first = null;
        last = null;
        n =0;
    }
    boolean isEmpty(){
       return first == null;
    }
    int size(){
        return n;
    }
    public void enqueue(Item item) {
        Node<Item> node = new Node<>();
        node.item = item;
        if(first == null){
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        n++;
    }
    public Item dequeue(){
        if(isEmpty()){
            return null;
        }
        Item returned = first.item;
        n--;
        if(first.next == null){
            last = first = null;
        }
        else {
            first = first.next;
        }
        return returned;
    }

    // .ietartor kind of create new class objecct reference
    // and from beginning //
        @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first,last);
    }
    private class ListIterator<Item> implements Iterator<Item>{
        Node<Item> current;
        ListIterator(Node<Item> first,Node<Item> last){
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {

            Item ans = current.item;
            current = current.next;
            return ans;
        }
    }
}
