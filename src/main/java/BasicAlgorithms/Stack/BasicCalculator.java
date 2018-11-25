package BasicAlgorithms.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
public class BasicCalculator {
    public int calculate(String s) {
        List<String> list = new ArrayList<>();
        String array[] = null;
        int index = 0;
        for(int i=0;i<s.length();){
            int num=0;
            if(Character.isDigit(s.charAt(i))){
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                list.add(String.valueOf(num).trim());
            }
            else if(i<s.length() && s.charAt(i)=='('){
                list.add(String.valueOf(s.charAt(i)).trim());
                i++;
            }
            else if(i<s.length() && s.charAt(i)==')'){
                list.add(String.valueOf(s.charAt(i)).trim());
                i++;
            }
            else if(i<s.length() && s.charAt(i)=='+'){
                list.add(String.valueOf(s.charAt(i)).trim());
                i++;
            }
            else if(i<s.length() && s.charAt(i)=='-'){
                list.add(String.valueOf(s.charAt(i)).trim());
                i++;
            }
            else {
                i++;
            }
        }
       // System.out.println("list"+list);
        array = new String[list.size()];
        for(String tokens:list){
            array[index++] = tokens;
        }
        return evaluateExpression(array);
        //return -1;
    }
    public int evaluateExpression(String[] expression) {
        if (expression == null || expression.length == 0) {
            return 0;
        }
        // all i need is operator stack to push operators //
        // and numb stack to keep pushng poppoing and computing numbers
        // so two stacks are required
        // if we had to conver to ttree then i i would hhave requred stack carrying trree node instead of numbers
        // if i had to conver to RPN i would have required list to keep adding so that we dont comupete that time //
        // we just keep adding operators to the list instead of stack !!1
        Stack<Integer> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();
        for (String token : expression) {
            if (isNumber(token)) {
                numStack.push(Integer.valueOf(token));
            } else if (token.equals("(")) {
                opStack.push(token);
            } else if (token.equals(")")) {
                while (!opStack.peek().equals("(")) {
                    numStack.push(compute(numStack.pop(), numStack.pop(), opStack.pop()));
                }
                opStack.pop();  // pop out "("
            } else {
                // if values placed iin stack is more imp that fetch it and process it
                // befpre you push the current token operators to the stack !!! as asimple as that !@!
                while (!opStack.isEmpty() && getPriority(opStack.peek()) >= getPriority(token)) {
                    numStack.push(compute(numStack.pop(), numStack.pop(), opStack.pop()));
                }
                opStack.push(token);
            }
        }
        while (!opStack.isEmpty()) {
            numStack.push(compute(numStack.pop(), numStack.pop(), opStack.pop()));
        }
        return numStack.isEmpty() ? 0 : numStack.pop();
    }

    private boolean isNumber(String token) {
        return Character.isDigit(token.charAt(0));
    }

    private int getPriority(String op) {
        if (op.equals("(")) {
            return 0;
        } else if (op.equals("+") || op.equals("-")) {
            return 1;
        } else {
            return 2;
        }
    }

    private int compute(int num2, int num1, String token) {
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

    public static void main(String[] args) {
        BasicCalculator bs = new BasicCalculator();
        System.out.println(bs.calculate("(1+(4+5+2)-3)+(6+8)"));
       // "1 + 1" = 2
       //" 2-1 + 2 " = 3
        //"(1+(4+5+2)-3)+(6+8)" = 23
    }
}
