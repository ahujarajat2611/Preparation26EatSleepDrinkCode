package BasicAlgorithms.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
/*
Given a string with unbalanced brackets how do you remove minimum number
 * of extra brackets so that you are left with balanced brackets in the string
 *
 * e.g )( -> empty string
 *     (a) -> (a)
 *     ((mnq)abc))) -> ((mna)abc)
 *     (abc)(( -> (abc)
 *
 *     https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/RemoveExtraBrackets.java
 */
public class RemoveInvalidChars {
    public int remove(char input[]) {
        if (input == null) {
            return 0;
        }
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i] != '(' && input[i] != ')')
                continue;

            // add opening bracekets
            if (input[i] == '(') {
                deque.addFirst(i);
            } else if (input[i] == ')') {
                if (!deque.isEmpty() && input[deque.getFirst()] == '(') {
                    deque.pollFirst();
                } else {
                    deque.addFirst(i);
                }
            }
        }
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if (!deque.isEmpty() && i == deque.getLast()) {
                deque.pollLast();
            } else {
                input[index++] = input[i];
            }
        }
        return index;
    }
    // really nice nicee nic e

    public String balance(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        // stack would have all indexes to remove

        for(int i=0;i<s.length();i++){
            Character c= s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else {
                // pushing ) into the stack
                if(stack.empty()){
                    stack.push(i);
                }

                // if not empty try to see match
                Integer peek = stack.peek();
                if(matching(s.charAt(peek),c)){
                    stack.pop();
                }
                else {
                    // not matched means for sure its gona be )) case in the stack
                    stack.push(i);
                }

            }
        }
        while (!stack.isEmpty()){
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }

    private boolean matching(Character peek, char c) {
        if (peek == '(' && c == ')') {
            return true;
        }
        if (peek == '[' && c == ']') {
            return true;
        }
        if (peek == '{' && c == '}') {
            return true;
        }
        return false;
    }
}