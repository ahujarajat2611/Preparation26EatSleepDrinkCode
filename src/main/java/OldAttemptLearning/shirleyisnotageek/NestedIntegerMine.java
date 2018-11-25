package OldAttemptLearning.shirleyisnotageek;

import DSA.nodes.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by hadoop on 5/3/18.
 */
public class NestedIntegerMine implements Iterator<Integer>{

    List<NestedInteger> nestedIntegerList = new ArrayList<NestedInteger>();
    Stack<NestedInteger> stack = new Stack<>();
    NestedIntegerMine(List<NestedInteger> list ){
        this.nestedIntegerList = list;
        for(NestedInteger nestedInteger :list){
            stack.push(nestedInteger);
        }
    }
    @Override
    public boolean hasNext() {

        while (!stack.isEmpty() && !stack.peek().isInteger()){
           NestedInteger nestedInteger =  stack.pop();
           for(int i = nestedInteger.getList().size()-1;i>=0;i--){
               stack.push(nestedInteger.getList().get(i));

           }

        }
        return stack.peek().isInteger();
       // return false;
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            return null;
        }
        return stack.pop().getInteger();
    }
}
