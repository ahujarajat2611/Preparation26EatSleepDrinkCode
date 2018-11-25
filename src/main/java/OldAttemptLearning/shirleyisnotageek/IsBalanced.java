package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
public class IsBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            return maxDepth(root) != -1;
        }
        private int maxDepth(TreeNode root)
        {
            if (root == null)
                return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            //if left subtree or right subtree has maxDepth greater than one or the maxDepth between left and right is greater than one, then the tree is not balanced
            if (left == -1 || right == -1 || Math.abs(left - right) > 1)
                return -1;
            return Math.max(left, right) + 1;
        }
    }
}
