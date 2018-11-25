package DSA.Stack;

/**
 * Created by hadoop on 11/2/18.
 */
import java.util.*;
public class StackMin {
    private Stack stack;
    private Stack minStack;
    public void pushOptimizedSpace(Integer data) {
        stack.push(data);
        Integer topOfMinStack = (Integer) minStack.peek();

        if (topOfMinStack == null)
            minStack.push(data);
        else if (data <= topOfMinStack)
            minStack.push(data);
    }

    public Object popOptimizedSpace() {
        Integer topOfStack = (Integer) stack.pop();
        Integer topOfMinStack = (Integer) minStack.peek();
        if (topOfStack <= topOfMinStack)
            minStack.pop();
        return topOfStack;
    }

    public void push(Integer data) {
        stack.push(data);
        Integer topOfMinStack = (Integer) minStack.peek();
        if (topOfMinStack == null)
            minStack.push(data);
        else if (data < topOfMinStack)
            minStack.push(data);
        else
            minStack.push(topOfMinStack);
    }

    public Object pop() {
        minStack.pop();
        return stack.pop();
    }

    public Object getMinimum() {
        return minStack.peek();
    }
}
