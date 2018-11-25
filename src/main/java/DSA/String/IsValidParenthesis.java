package DSA.String;

import java.util.Stack;

/**
 * Created by hadoop on 12/2/18.
 */
public class IsValidParenthesis {
    public boolean isValidParantheses(char[] a, int n) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < n; i++) {
            ch = a[i];
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{')
                        return false;
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(')
                        return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[')
                        return false;
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
