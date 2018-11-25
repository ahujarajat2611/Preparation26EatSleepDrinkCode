package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
import java.util.*;

public class IsValidParenthesis {
    public boolean isValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
            } else if (arr[i] == ')' || arr[i] == ']' || arr[i] == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char c = stack.pop();
                    if ((c == '(' && arr[i] == ')') ||
                            (c == '[' && arr[i] == ']') ||
                            (c == '{' && arr[i] == '}')) {
                        continue;
                    }
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
