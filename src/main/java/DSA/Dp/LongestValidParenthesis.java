package DSA.Dp;

import java.util.Stack;

/**
 * Created by hadoop on 19/2/18.
 */
public class LongestValidParenthesis {
    public static int longestValidParentheses2(String str) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && str.charAt(stack.peek()) == '{') {
                    stack.pop();
                } else {
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
        maxLen = Math.max(maxLen, right);
        return maxLen;
    }

}
