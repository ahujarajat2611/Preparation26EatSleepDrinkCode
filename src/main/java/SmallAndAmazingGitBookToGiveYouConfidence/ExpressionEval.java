package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Stack;


/**
 * Created by hadoop on 22/9/17.
 */
public class ExpressionEval {
    public int expression(String []expression){
        Stack<String> opStack = new Stack<>();
        Stack<Integer> computeStack = new Stack<>();
        
        for(String token:expression){
            if(isNumberToken(token)){
                computeStack.push(Integer.parseInt(token));
                continue;
            }
            if(token.equals("(")){
                opStack.push(token);
            }
            if(token.equals(")")){
                while (!opStack.isEmpty() && opStack.peek()!="("){
                    computeStack.push(compute(opStack.pop(),computeStack.pop(),computeStack.pop()));
                }
            }
            else {
                while (!opStack.isEmpty() && getPriorityToken(token)<=getPriorityToken(opStack.peek())){
                    computeStack.push(compute(opStack.pop(),computeStack.pop(),computeStack.pop()));
                }
                // i think token needs to be addded to operator stack
            }
        }
        while (!computeStack.isEmpty()){
            computeStack.push(compute(opStack.pop(),computeStack.pop(),computeStack.pop()));
        }
        return computeStack.pop();
    }

    private int compute(String token, Integer num2, Integer num1) {
        int result;
        if (token.equals("+")) {
            result = num1 + num2;
        } else if (token.equals("-")) {
            result = num1 - num2;
        } else if (token.equals("*")) {
            result = num1 * num2;
        } else {
            result = num1 / num2;
        }
        return result;
    }

    int getPriorityToken(String op){

            if (op.equals("(")) {
                return 0;
            } else if (op.equals("+") || op.equals("-")) {
                return 1;
            } else {
                return 2;
            }
    }

    private boolean isNumberToken(String token) {
        return Character.isDigit(token.charAt(0));
    }
}
