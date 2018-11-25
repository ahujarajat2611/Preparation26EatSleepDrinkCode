package DSA.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 11/2/18.
 */
public class StackUsingOneQueue {
    Queue<Object> q = new LinkedList<>();

    // Time : O(n)
    public void push(Object data) {
        q.offer(data);
        int size = q.size();
        for (int i = 0; i < size - 1; i++)
            q.offer(q.poll());
    }

    // Time : O(1)
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return q.poll();
    }

    // Time : O(1)
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return q.peek();
    }

    // Time : O(1)
    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingOneQueue q = new StackUsingOneQueue();
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        System.out.println(q.pop());
        System.out.println(q.peek());
        q.push(50);
        q.push(60);
    }
}
