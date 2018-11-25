package OldAttemptLearning.shirleyisnotageek;

import DSA.nodes.NestedInteger;

/**
 * Created by hadoop on 5/3/18.
 */
import java.util.*;
public class NestedIntegerLevelWise {
    Stack<NestedInteger> stack = new Stack<>();
    Queue<Pair> entryQueue = new LinkedList<>();

    public NestedIntegerLevelWise(List<NestedInteger> nestedIntegers) {
        // for (int i = nestedIntegers.size() - 1; i >= 0; i--) {
        //     stack.push(nestedIntegers.get(i));
        // }

        for(NestedInteger nestedInteger :nestedIntegers){
            entryQueue.add(new Pair(nestedInteger,1));
        }
    }

    public Integer next() {
        if(!hasNext()){
            return null;
        }
        while(!entryQueue.isEmpty()){
            Pair polled = entryQueue.poll();
            if(polled.nestedInteger.isInteger()){
                return polled.nestedInteger.getInteger();
            }
            else {
                for(NestedInteger nestedInteger:polled.nestedInteger.getList()) {
                    entryQueue.add(new Pair(nestedInteger,polled.depth+1));
                }
            }
        }
        return -1;
//             if (!hasNext()) {
//                 return null;
//             }

//             return stack.pop().getInteger();
    }

    public boolean hasNext() {
        return !entryQueue.isEmpty();
        // while (!stack.isEmpty() && !stack.peek().isInteger()) {
        //     List<NestedInteger> list = stack.pop().getList();
        //     for (int i = list.size() - 1; i >= 0; i--) {
        //         stack.push(list.get(i));
        //     }
        // }
        // return !stack.isEmpty();
    }


    public int function(List<NestedInteger> nestedIntegerList){


        int sum =0;
        while (!entryQueue.isEmpty()){
            Pair pair = entryQueue.poll();
            if(pair.nestedInteger.isInteger()){
                sum = sum+ pair.nestedInteger.getInteger()*pair.depth;
            }
            else {
                for(NestedInteger nestedInteger:pair.nestedInteger.getList()) {
                    entryQueue.add(new Pair(nestedInteger,pair.depth+1));
                }
            }
        }
        return sum;
    }

    private class Pair{
        NestedInteger nestedInteger;
        Integer depth;
        Pair(NestedInteger nestedInteger,Integer depth){
            this.nestedInteger = nestedInteger;
            this.depth = depth;
        }
    }
}
