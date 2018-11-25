package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < max && root.val > min &&
                helper(root.left, min, root.val) &&
                helper(root.right, root.val, max)) {
            return true;
        }
        return false;
    }
}
