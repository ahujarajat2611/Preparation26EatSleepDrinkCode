package BasicAlgorithms.Stack;

import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
// once we have the RPN ready from the expression
    // its matter of one stack that too integer stack
    // operator stack is not required in this case
    // since we have used operator stack to prepara RPN exprssoion !!

public class EvalRPN {
    public int evalRpn(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if(isOperator(token)){
                stack.push(compute(stack.pop(),stack.pop(),token));
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
            return true;
        }
        return false;
    }
    int compute(int num2, int num1,String operator){
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