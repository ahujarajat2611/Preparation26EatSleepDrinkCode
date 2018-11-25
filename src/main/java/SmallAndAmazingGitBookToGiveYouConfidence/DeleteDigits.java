package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Stack;

/**
 * Created by hadoop on 21/9/17.
 */
public class DeleteDigits {
    public String DeleteDigits(String A, int k) {
        Stack<Integer> stack = new Stack<>();
        for (char c : A.toCharArray()) {
            int num = c - '0';
            // ww want min number so we are using
            // this technique if current is min number then better remove
            // elememns from stack
            while (k > 0 && !stack.isEmpty() && num < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        // construct result
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String result = sb.reverse().toString();
        // skip leading 0
        int start = 0;
        while (result.charAt(start) == '0') {
            start++;
        }
        // handle special case
        if (start == result.length()) {
            return "0";
        }
        return result.substring(start);
    }
}
