package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Stack;

/**
 * Created by hadoop on 19/9/17.
 */
public class Myqueue {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void push(int x){
        inStack.push(x);
    }
    public int pop(){
        if(outStack.isEmpty()){
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    public boolean isEmpty(){
        if(inStack.isEmpty() && outStack.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
