package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*Thinking process:
making use depth first search.
same process as maxDepth() method.
after recursive call, check if Math.abs(left - right) > 1. If so, return -1.
If any case return -1, they all return -1.
at the top return, check if -1.
*/
/*
    Use helper to calculate depth,
    and also check if left/right depth differ by
     1. If all good, return actual depth


 */
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) > 0;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // post order traversal
        int leftDepth = helper(node.left);
        int rightDepth = helper(node.right);

        if (leftDepth < 0 || rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1) {
            return Integer.MIN_VALUE;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}
