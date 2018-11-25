package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 9/12/17.
 */
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
        // in the end check if stack is empy or not ...
        return stack.isEmpty();
    }
}
