package AwangDevLintCode;

import java.util.List;

import java.util.*;
// we maintain global index ( must ) to let us know which index needs to be consideredd
// next will take element and then increase index to next one
// but it could be the case that next index is emptyy
// call hasnext to finx that keep increasing index until you find correcct index that has element
public class ZigzagIterator {
    
     private List<Iterator<Integer>> iterators;
     int index;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new ArrayList<>();
        iterators.add(v1.iterator());
        iterators.add(v2.iterator());
    }

    public int next() {
        if (!hasNext()) {
                throw new RuntimeException("Empty iterator!");
            }
        int el = iterators.get(index).next();
        index = (index + 1) % iterators.size();
        return el;
    }

    public boolean hasNext() {        
            Iterator<Integer> it = iterators.get(index);
            while (!it.hasNext()){
                // whatt a a solution // you need to remove that index that is of no use at all !!!!
                iterators.remove(index);
                if(iterators.size() == 0){
                    return false;
                }
                index= (index+1)%iterators.size();
                it = iterators.get(index);
            }
         return true;
    }
}