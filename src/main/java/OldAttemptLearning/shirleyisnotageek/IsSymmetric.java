package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);

    }
    private boolean isSymmetricHelper(TreeNode left, TreeNode right)
    {
        if (left == null)
            return right == null;
        if (right == null)
            return left == null;
        if (left.val != right.val)
            return false;
        if (!isSymmetricHelper(left.left, right.right))
            return false;
        if (!isSymmetricHelper(right.left, left.right))
            return false;
        return true;
    }
}
