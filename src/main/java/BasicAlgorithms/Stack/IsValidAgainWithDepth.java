package BasicAlgorithms.Stack;

import java.util.Stack;

/**
 * Created by hadoop on 18/10/17.
 */
public class IsValidAgainWithDepth {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c== '[' || c== '{'){
                stack.push(c);
                // we are pushing chars .. so better have clear mind what you want to push
                // direct value or index .. yoou almost fucked up with index and value
                // in matching fucniton 1!!
            }
            else {

                if(stack.isEmpty()){
                    return false;
                }
                Character peek = stack.peek();
                if(matching(peek,c)){
                    stack.pop();
                }
                else {
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