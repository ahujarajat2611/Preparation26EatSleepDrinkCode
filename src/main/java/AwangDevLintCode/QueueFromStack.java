package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
public class QueueFromStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public void pourS2ToS1(){
        while (!stack2.empty()) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
    }
    public QueueFromStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.empty()) {
            pourS2ToS1();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.empty()) {
            pourS2ToS1();
        }
        return stack1.peek();
    }
}
