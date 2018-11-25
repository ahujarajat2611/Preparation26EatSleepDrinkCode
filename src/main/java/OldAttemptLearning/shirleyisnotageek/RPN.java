package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

Not a tricky problem. Using a stack can make your life much easier.
However, one thing I should always remember: use .equals() to compare strings instead of ==

"The function checks the actual contents of the string, the == operator checks whether the references to the objects are equal. ".
 */

public class RPN {
    public int evalRPN(String[] tokens) {
        if (tokens == null)
            return 0;
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<Integer> ();
        for (String token : tokens)
        {
            if (!operators.contains(token))
            {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();
             
            if (token.equals("+"))
                stack.push(a + b);
            else if (token.equals("-"))
                stack.push(a - b);
            else if (token.equals("*"))
                stack.push(a * b);
            else
                stack.push(a / b);
        }
        return stack.pop();
    }
}