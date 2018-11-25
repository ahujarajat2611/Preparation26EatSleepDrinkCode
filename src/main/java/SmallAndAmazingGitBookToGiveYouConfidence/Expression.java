package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by hadoop on 22/9/17.
 */
public class Expression {


    public ArrayList<String> convertToRPN(String[] expression) {

        Stack<String> operatorStack = new Stack<>();
        ArrayList<String> rpn = new ArrayList<>();
        for(String token: expression){
            if(isNumber(token)){
                rpn.add(token);
            }
            else if(token.equals("(")){
                operatorStack.push(token);
            }
            else if(token.equals(")")){
                while (!operatorStack.empty() && operatorStack.peek()!=")"){
                    rpn.add(operatorStack.pop());
                }
                operatorStack.pop();
            }
            else {
                while (!operatorStack.empty() && getPriority(operatorStack.peek())>=getPriority(token)){
                    rpn.add(operatorStack.pop());
                }
                operatorStack.add(token);
            }
        }
        while (!operatorStack.empty()){
            rpn.add(operatorStack.pop());
        }
        return rpn;
    }

    public static void main(String[] args) {
        Expression expression = new Expression();
        System.out.println(expression.convertToRPN(new String[]{"1","+","3"}));
    }
    public boolean isNumber(String token){
        return Character.isDigit(token.charAt(0));
    }
    private int getPriority(String op) {
        if (op.equals(")")) {
            return 0;
        } else if (op.equals("+") || op.equals("-")) {
            return 1;
        } else {
            return 2;
        }
    }
        private class Solution {
        /**
         * @param expression: A string array
         * @return: The Polish notation of this expression
         */
        public ArrayList<String> convertToPN(String[] expression) {
            ArrayList<String> result = new ArrayList<>();
            if (expression == null || expression.length == 0) {
                return result;
            }
            Stack<String> opStack = new Stack<>();
            for (int i = expression.length - 1; i >= 0; i--) {
                String token = expression[i];
                if (isNumber(token)) {
                    result.add(token);
                } else if (token.equals(")")) {
                    while (!opStack.peek().equals(")")) {
                        result.add(opStack.pop());
                    }
                    opStack.pop();
                } else if (token.equals("(")) {
                    opStack.push(token);
                } else {
                    while (!opStack.isEmpty() && getPriority(opStack.peek()) > getPriority(token)) {
                        result.add(opStack.pop());
                    }
                    opStack.push(token);
                }
            }
            while (!opStack.isEmpty()) {
                result.add(opStack.pop());
            }
            Collections.reverse(result);
            return result;
        }

        private boolean isNumber(String token) {
            return Character.isDigit(token.charAt(0));
        }

        private int getPriority(String op) {
            if (op.equals(")")) {
                return 0;
            } else if (op.equals("+") || op.equals("-")) {
                return 1;
            } else {
                return 2;
            }
        }
    }
    private class Solution1 {
        /**
         * @param expression: A string array
         * @return: The Reverse Polish notation of this expression
         */
        public ArrayList<String> convertToRPN(String[] expression) {
            ArrayList<String> result = new ArrayList<>();
            if (expression == null || expression.length == 0) {
                return result;
            }
            Stack<String> opStack = new Stack<>();
            for (String token : expression) {
                if (isNumber(token)) {
                    result.add(token);
                } else if (token.equals("(")) {
                    opStack.push(token);
                } else if (token.equals(")")) {
                    while (!opStack.peek().equals("(")) {
                        result.add(opStack.pop());
                    }
                    opStack.pop();
                } else {
                    while (!opStack.isEmpty() && getPriority(opStack.peek()) >= getPriority(token)) {
                        result.add(opStack.pop());
                    }
                    opStack.push(token);
                }
            }
            while (!opStack.isEmpty()) {
                result.add(opStack.pop());
            }
            return result;
        }

        // what a function thatt can be used to deal with chars
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
    }
    private class Solution3 {
        private class ExpressionTreeNode{
            String op;
            ExpressionTreeNode left;
            ExpressionTreeNode right;

            public ExpressionTreeNode(String op) {
                this.op = op;
            }
        }
        /**
         * @param expression: A string array
         * @return: The root of expression tree
         */
        public ExpressionTreeNode build(String[] expression) {
            if (expression == null || expression.length == 0) {
                return null;
            }
            Stack<ExpressionTreeNode> numStack = new Stack<>();
            Stack<String> opStack = new Stack<>();
            for (String token : expression) {
                if (isNumber(token)) {
                    numStack.push(new ExpressionTreeNode(token));
                } else if (token.equals("(")) {
                    opStack.push(token);
                } else if (token.equals(")")) {
                    while (!opStack.peek().equals("(")) {
                        numStack.push(buildNode(numStack.pop(), numStack.pop(), opStack.pop()));
                    }
                    opStack.pop();
                } else {
                    while (!opStack.isEmpty() && getPriority(opStack.peek()) >= getPriority(token)) {
                        numStack.push(buildNode(numStack.pop(), numStack.pop(), opStack.pop()));
                    }
                    opStack.push(token);
                }
            }
            while (!opStack.isEmpty()) {
                numStack.push(buildNode(numStack.pop(), numStack.pop(), opStack.pop()));
            }
            return numStack.isEmpty() ? null : numStack.pop();
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

        private ExpressionTreeNode buildNode(ExpressionTreeNode node2, ExpressionTreeNode node1, String op) {
            ExpressionTreeNode root = new ExpressionTreeNode(op);
            root.left = node1;
            root.right = node2;
            return root;
        }
    }
    private class Solution4 {
        public int evaluateExpression(String[] expression) {
            if (expression == null || expression.length == 0) {
                return 0;
            }

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
    }
}
/*
//package BasicAlgorithms.Stack;
//
//import java.util.Stack;
//
///**
// * Created by hadoop on 19/10/17.
// */
//public class GeneralExpressionPractice {
//    public int evaluateExpression(String[] expression) {
//        if(expression == null || expression.length == 0){
//            return 0;
//        }

//        // Lets take 2 stacks
//        //
// one number stack / list/ expression tree stack
// where we store result

//        // another is operatot stack
//
// if we get ( we push into that
//
// if we get ) we pop until ) and finall pop ) as well

//
// if we get operator then we compute previous things as per priority

//
// finall we push this operator

//
// once we converd all expression

//
// we pop things frm stack and perform things at last
//
// two stacka re requires must must must
//
// if number we push number stack
//
// if operator opetrator stack and perfomr thinsgs and push it to numberstack
//        // if open ( operatot stack for time being
//        // if close fetch from operatos stak and push to number stack
//        //
//        Stack<Integer> stack = new Stack<Integer>();
//        Stack<String> opStack = new Stack<>();
//        for(String token:expression) {
//            if (isNumber(token)) {
//                stack.push(Integer.parseInt(token));
//            } else if (token.equals("(")) {
//                opStack.push(token);
//            } else if (token.equals(")")) {
//                numStack.push(compute(numStack.pop(), numStack.pop(), opStack.pop()));
//                opStack.push(token);
//            } else {
//                while (!opStack.isEmpty() && getPriority(opStack.peek()) > getPriority(token)) {
//                    stack.push(compute(token, stack.pop(), stack.pop));
//                }
//            }
//        }
//    }
//    }
//}
// */