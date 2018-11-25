package BasicAlgorithms.Design;

import java.util.Queue;

import java.util.*;
class MyStack {
    Queue<Integer> first;
    Queue<Integer> second;
    int flag = 1;
    /** Initialize your data structure here. */
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(flag == 1){
            first.add(x);
            while(second.size() != 0){
                first.add(second.poll());
            }
            flag = 0;
        }
        else{
            second.add(x);
            while(first.size() != 0){
                second.add(first.poll());
            }
            flag = 1;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(flag == 1)
            return second.poll();
        else
            return first.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if(flag == 1)
            return second.peek();
        else
            return first.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(flag == 1)
            return second.size() == 0;
        else
            return first.size() == 0;
    }
}