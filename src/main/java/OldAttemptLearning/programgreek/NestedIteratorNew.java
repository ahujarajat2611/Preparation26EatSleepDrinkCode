package OldAttemptLearning.programgreek;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by hadoop on 22/8/17.
 */
public class NestedIteratorNew implements Iterator<Integer>{
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
