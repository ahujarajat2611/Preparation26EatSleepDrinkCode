package DSA.Design;

import DSA.nodes.NestedInteger;

import java.util.*;
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack = new Stack<>();
    Integer current = null;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList != null) {
            stack.push(nestedList.iterator());
        }
    }

    @Override
    public Integer next() {
        return current;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> node = stack.peek();
    
            // This will clear out empty iterators.
            if (!node.hasNext()) {
                stack.pop();
                continue;
            }
            
            // If the value is an integer, done - load up and return.
            // Otherwise push the current list to the top of the stack and continue.
            NestedInteger value = node.next();
            if (value.isInteger()) {
                current = value.getInteger();
                return true;
            } else {
                stack.push(value.getList().iterator());
            }
        }
        
        return false;
    }
    public static void main(String... args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        NestedIterator obj = new NestedIterator(nestedList);
    }
    /*



    class NestedIteratorNew implements Iterator<Integer>{
    public static void main(String args[]){

    }
    Integer top =null;
    Stack<Iterator<NestedInteger>> stack = new Stack<>();
    NestedIteratorNew(List<NestedInteger> list){
        stack.push(list.iterator());
    }
    @Override
    public boolean hasNext() {
        if(top !=null){
            return true;
        }
        while (!stack.isEmpty()){
            Iterator<NestedInteger> it = stack.peek();
            if(it.hasNext()){
                NestedInteger nestedInteger = it.next();
                if(nestedInteger.isInteger()){
                    top = nestedInteger.getInteger();
                    return true;
                }
                else {
                    stack.push(nestedInteger.getList().iterator());
                }
            }
            else{
                stack.pop();
            }
        }
        return false;
    }


    @Override
    public Integer next() {
        return top;
    }
}





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

     */
}