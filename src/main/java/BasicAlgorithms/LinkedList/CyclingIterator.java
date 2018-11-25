package BasicAlgorithms.LinkedList;

import java.util.Iterator;

import java.util.*;
public class CyclingIterator {
 
    private List<Iterator<Integer>> Iterators;
    int index;
    public CyclingIterator(List<List<Integer>> lists) {
        Iterators = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            Iterators.add(lists.get(i).iterator());
        }
    }
 
    public int next() {
        if (!hasNext()) {
            throw new RuntimeException("Empty Iterator!");
        }
        Iterator<Integer> curr = Iterators.get(index);
        int toReturn = curr.next();
        if (!curr.hasNext()) {
            Iterators.remove(index);
        } else {
            index++;
        }
        if (index == Iterators.size()) {
            index = 0;
        }
        return toReturn;
    }
 
    public boolean hasNext() {
        return Iterators.size() > 0;
    }
}