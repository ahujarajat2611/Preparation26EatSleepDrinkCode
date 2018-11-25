package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 22/1/18.
 */
/*
Remove K Digits
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

Using a stack, pop out the previous digits that is larger if doesn't exceed n. If the string is in ascending order, pop out any extra chars. Remove all "0"s in the front and return result.

 */
public class RemoveKdigit {
    public String removeKdigits(String num, int k) {
        if (num.length() == 0) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (stack.size() > num.length() - k) {
            stack.pop();
        }
        StringBuilder rst = new StringBuilder();
        while (!stack.isEmpty()) {
            rst.append(stack.pop());
        }
        int index = rst.length();
        while (index > 0 && rst.charAt(index - 1) == '0') {
            index--;
        }
        rst.delete(index, rst.length());
        return rst.length() == 0 ? "0" : rst.reverse().toString();
    }
}
