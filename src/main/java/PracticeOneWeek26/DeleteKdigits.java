package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 10/12/17.
 */
public class DeleteKdigits {
    public String DeleteDigits(String A, int k) {
        Stack<Integer> stack = new Stack<>();
        int popCount = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            int num = (int)(A.charAt(i) - '0');
            if (stack.isEmpty()) {
                stack.push(num);
            } else if (num >= stack.peek()) {
                stack.push(num);
            } else {
                if (popCount < k) {
                    stack.pop();
                    i--;
                    popCount++;
                } else {
                    stack.push(num);
                }
            }
        }
        while (popCount < k) {
            stack.pop();
            popCount++;
        }
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.toString();
    }
}
