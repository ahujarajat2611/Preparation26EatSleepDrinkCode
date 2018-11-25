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