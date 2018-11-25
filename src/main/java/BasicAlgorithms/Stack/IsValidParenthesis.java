package BasicAlgorithms.Stack;

import java.util.Stack;

/**
 * Created by hadoop on 18/10/17.
 */
public class IsValidParenthesis {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if(s.length() == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && matching(stack.peek(), c)) {
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
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