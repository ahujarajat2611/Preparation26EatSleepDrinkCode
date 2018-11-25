package AwangDevLintCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
https://wxx5433.gitbooks.io/interview-preparation/content/part_ii_leetcode_lintcode/stack/evaluate_reverse_polish_notation.html

 */

/**
 * Created by hadoop on 22/9/17.
 */
public class Expression {

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
                } else if (token.equals("(")) {
                    while (!opStack.peek().equals(")")) {
                        result.add(opStack.pop());
                    }
                    opStack.pop();
                } else if (token.equals(")")) {
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
        /*

        Simple thout process
        get open brace push to stack
        close .. fetch all and add to result
        get token .. pull out all toeksn from stack if their prioriry is more
        and then add to result
        fianllly add this token to stack !!!!

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
    // GIVEN RPN calculate no need of two stacks one enough to get things done
    // since RPN wnt have priorrity cases and all !!!
    // thats how coompuer does calcultation !!!

    public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token: tokens) {
                if (isOperator(token)) {
                    stack.push(compute(token, stack.pop(), stack.pop()));
                } else {
                    stack.push(Integer.valueOf(token));
                }
            }
            return stack.pop();
        }

        private boolean isOperator(String token) {
            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {
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