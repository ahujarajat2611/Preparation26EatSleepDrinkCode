package AwangDevLintCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 4/2/18.
 */
public class StackFromQueue {
    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();
    // Push a new item into the stack
    public void push(int x) {
        q1.offer(x);
    }

    // see how we have optimized push operation
    // things are dealt at pop level !!!!!
    /// after every pop or polll we are swapping things !!!!
    // Pop the top of the stack
    public void pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        q1.poll();
        swap();
    }

    // Return the top of the stack
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int rst = q1.poll();
        q2.offer(rst);
        swap();
        return rst;
    }

    public void swap(){
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

class MyStack {
    Queue<Integer> first;
    Queue<Integer> second;
    int flag = 1;
    /** Initialize your data structure here. */
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }


    //  only things will get swapped at push level only !!
    // nothing else !!
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

class MyStackAgain {
    private Queue<Integer> queue;
    private Queue<Integer> tempQueue;

    /** Initialize your data structure here. */
    public MyStackAgain() {
        queue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    /** Find the top and backfill queue with all consumed items */
    private int findTop() {
        while (queue.size() > 1) {
            tempQueue.offer(queue.poll());
        }
        int num = queue.poll();
        queue = tempQueue;
        tempQueue = new LinkedList<>();
        return num;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return findTop();
    }

    /** Get the top element. */
    public int top() {
        int num = findTop();
        queue.offer(num);
        return num;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}