package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Stack;

/**
 * Created by hadoop on 21/9/17.
 */
public class evalRPN {

    public int evalRpn(String []tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if(isOperator(token)){
                stack.push(compute(token,stack.pop(),stack.pop()));
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        if(token.equals("+") || token.equals("-") || token.equals("*") ||token.equals("/")){
            return true;
        }
        return false;
    }
    private int compute(String operator, int num2, int num1) {
        int result = 0;
        switch (operator.charAt(0)) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
        }
        return result;
    }
}
