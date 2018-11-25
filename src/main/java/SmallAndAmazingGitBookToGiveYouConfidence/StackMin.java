package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Stack;

/**
 * Created by hadoop on 19/9/17.
 */
public class StackMin {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();

    void push(Integer x){
        stack.push(x);
        // i think we need to insert when x is less than peek
        // then only we should be addding into stack !!
        if(minstack.isEmpty() || x>=minstack.peek()){
            minstack.push(x);
        }
    }
    Integer pop(){
        int value = stack.pop();
        if(value == minstack.peek()){
            minstack.pop();
        }
        return value;
    }
    Integer top(){
        return stack.peek();
    }
    Integer getMin(){
        if(!minstack.isEmpty()) {
            return minstack.peek();
        }
        return -1;
    }
}
