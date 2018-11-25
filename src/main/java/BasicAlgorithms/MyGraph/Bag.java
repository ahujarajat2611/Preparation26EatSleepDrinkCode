package BasicAlgorithms.MyGraph;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

/**
 * Created by hadoop on 19/10/17.
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n; // suggest size of Bag
    public Bag(){
        first = null;
        int n=0;
    }

    public boolean isEmpty(){
        return first == null;
    }
    public int size() {
        return n;
    }

    // linkedlist addition shud be o(1) stupidddd
    public void add(Item item){
        // does nt matter null or not
            Node<Item> oldFirst = first;
            first = new Node<>();
            first.item = item;
            first.next = oldFirst;
            n++;
    }


    /*
    Iterable : A class that can be iterated over. That is, one that has a notion of "get me the first thing, now the next thing, and so on, until we run out."

Iterator : A class that manages iteration over an iterable. That is, it keeps track of where we are in the current iteration, and knows what the next element is and how to get it.

To make an object iterable it needs to emit an Iterator object. To enforce this contract, Iterable interface is to be used. It contains a method named iterator() and it returns Iterator. Hence, any class that implements Iterable will return an Iterator.

public interface Collection<E> extends Iterable<E> {}
For example take any Collection. A Collection is an interface that represents container for series of elements. Every collections like ArrayList, Vector implements Collection and so Iterator.

One advantage of Iterable is, when you implement Iterable then those object gets support for for:each loop syntax.
     */

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private static class ListIterator<Item> implements Iterator<Item>{
        Node<Item> current;
        ListIterator(Node<Item> first){
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node<Item> head = current;
            current = current.next;
            return head.item;
        }
    }
    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }
    public static void main(String []args){
        Bag<String> mybag = new Bag<>();
        mybag.add("rajat");
        mybag.add("ahuja");
        System.out.println(mybag.size());

        for(String x:mybag){
            System.out.println("string"+x);
        }
    }
}
