package smallmomentsmakeitbigger26;

import java.util.Stack;

/**
 * Created by hadoop on 18/10/17.
 */
public class LongestValid {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        /*
        push (
        find ) then check if stack is empty
        update publish pointer
        else
        poppeed its match
        and try to update match based on (after popping stack is empty
        // or filled )
         */

        int start = 0;
        int longest = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c =='('){
                stack.push(i);
                // if left push it just
            }
            else {
                // publish needs to be updated since it is invalide caser
                if(stack.isEmpty()){
                    start = i+1;
                }
                else {
                    // poopped its match

                    stack.pop();

                    // then calculate max length possible

                    // tricky cases
                    // after popping agaiiin check if stack if filled or not
                    // acccordingly calculate max height
                    if(stack.isEmpty()){
                        longest = Math.max(longest,i-start+1);
                    }
                    else {
                        longest = Math.max(longest,i-stack.peek());
                    }
                }
            }
        }
        return longest;
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
    public static void main(String args[]){
        LongestValid longestValid = new LongestValid();
        System.out.println(longestValid.longestValidParentheses(")()())"));
    }
    public static int longestValidParentheses2(String str) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && str.charAt(stack.peek()) == '{') {
                    stack.pop();
                } else {
                    // save all unmatched points and later calculate distance among them

                    stack.push(i);
                }
            }
        }

        if (stack.isEmpty())
            return str.length();
        int right = str.length(), left = 0;

        int maxLen = 0;
        while (!stack.isEmpty()) {
            left = stack.pop();
            maxLen = Math.max(maxLen, right - left - 1);
            right = left;
        }
        // after loop clean up work like usual process

        maxLen = Math.max(maxLen, right);
        return maxLen;
    }
}
