package OldAttemptLearning.shirleyisnotageek;

import java.util.Stack;

/**
 * Created by hadoop on 18/1/18.
 */
/*
It took me some time to understand the solution. The idea is for BST, traversing towards left side always leads a smaller value, and then going right side always lead to a larger value. And the minimum value of all nodes along the right path is the root, so if a node violates this rule, it's not a valid preorder traversal. The way we do it is to use a stack, every time we traverse left side, we push the number into the stack. When we publish to traverse the right side, we pop out the number that is smaller than current node and find its root value, which is assigned the minimum value. The idea is all the value that is smaller than minimum should already be traversed and popped out from stack, so any node that has a smaller value than the minimum is not a valid pre order traversal.
 */
public class VerifyPreorder {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack();
        int rootVal = Integer.MIN_VALUE;
        for (int n : preorder) {
            if (n < rootVal) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < n) {
                rootVal = stack.pop();
            }
            stack.push(n);
        }
        return true;
    }
}
