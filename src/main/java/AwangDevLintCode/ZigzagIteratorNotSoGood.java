package AwangDevLintCode;

import java.util.*;
/**
 * Created by hadoop on 18/1/18.
 */
/*
For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Hint:

How many variables do you need to keep track?
Two variables is all you need. Try with x and y.
Beware of empty rows. It could be the first few rows.
To write correct code, think about the invariant to maintain. What is it?
The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
Not sure? Think about how you would implement hasNext(). Which is more complex?
Common logic in two different places should be refactored into a common method.


Tags: Design
Similar Problems: (M) Binary Search Tree Iterator, (M) Zigzag Iterator, (M) Peeking Iterator

*/

public class ZigzagIteratorNotSoGood {
    public class CyclingIterator {

        private List<Iterator<Integer>> iterators;
        int index;
        public CyclingIterator(List<List<Integer>> lists) {
            iterators = new ArrayList<>();
            for (int i = 0; i < lists.size(); i++) {
                iterators.add(lists.get(i).iterator());
            }
        }

        public int next() {
            if (!hasNext()) {
                throw new RuntimeException("Empty iterator!");
            }
            Iterator<Integer> curr = iterators.get(index);
            int toReturn = curr.next();
            if (!curr.hasNext()) {
                iterators.remove(index);
            } else {
                index++;
            }
            if (index == iterators.size()) {
                index = 0;
            }
            return toReturn;
        }

        public boolean hasNext() {
            return iterators.size() > 0;
        }


        public int nextMine() {
            if (!hasNext()) {
                throw new RuntimeException("Empty iterator!");
            }
            ++index;
            Iterator<Integer> it = iterators.get(index);
            while (!it.hasNext()){
                iterators.remove(index);
                index= (index+1)%iterators.size();
                it = iterators.get(index);
            }
            return it.next();
        }

        public boolean hasNextMine() {
            return iterators.size() > 0;
        }


    }
    private List<Iterator<Integer>> iterators;
    int index;

    public int nextMineAccepted() {
        if (!hasNextMineAccepted()) {
            throw new RuntimeException("Empty iterator!");
        }
        int el = iterators.get(index).next();
        index = (index + 1) % iterators.size();
        return el;
    }

    public boolean hasNextMineAccepted() {
        Iterator<Integer> it = iterators.get(index);
        while (!it.hasNext()){
            iterators.remove(index);
            if(iterators.size() == 0){
                return false;
            }
            index= (index+1)%iterators.size();
            it = iterators.get(index);
        }
        return true;
        //return iterators.size() > 0;
    }
}
