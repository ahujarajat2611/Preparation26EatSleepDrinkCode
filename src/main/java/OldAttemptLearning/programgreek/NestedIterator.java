package OldAttemptLearning.programgreek;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hadoop on 22/8/17.
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> listofintger = new ArrayList<Integer>();
    Iterator<Integer> iterator ;
    NestedIterator(List<NestedInteger> list){
        flatten(list);
        iterator = listofintger.iterator();
    }
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }
    void flatten(List<NestedInteger> list){
        if(list == null || list.size() == 0){
            return;
        }
        else{
            for(NestedInteger nestedInteger :list){
                if(nestedInteger.isInteger()){
                    listofintger.add(nestedInteger.getInteger());
                }
                else{
                    flatten(nestedInteger.getList());
                }
            }
        }
    }
}
