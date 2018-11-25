package PracticeOneWeek26;

/**
 * Created by hadoop on 9/12/17.
 */
public class ValidateBinarySearch {
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
