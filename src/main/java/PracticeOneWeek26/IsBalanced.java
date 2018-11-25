package PracticeOneWeek26;

/**
 * Created by hadoop on 7/12/17.
 */
public class IsBalanced {
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
        int leftDepth = helper(node.left);
        int rightDepth = helper(node.right);

        if (leftDepth < 0 || rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1) {
            return Integer.MIN_VALUE;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
    private class TreeNode{
        TreeNode left;
        TreeNode right;
    }
}
