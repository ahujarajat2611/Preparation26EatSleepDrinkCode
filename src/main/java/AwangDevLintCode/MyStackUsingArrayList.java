package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
public class MyStackUsingArrayList {
    class Stack {
        private ArrayList<Integer> list = new ArrayList<Integer>();
        // Push a new item into the stack
        public void push(int x) {
            list.add(x);
        }

        // Pop the top of the stack
        public void pop() {
            if (list.size() > 0) {
                list.remove(list.size() - 1);
            }
        }

        // Return the top of the stack
        public int top() {
            if (list.size() > 0) {
                return list.get(list.size() - 1);
            }
            return -1;
        }

        // Check the stack is empty or not.
        public boolean isEmpty() {
            return list.size() == 0;
        }
    }
}
