package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
import java.util.*;
public class SearchRange {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(result, root, k1, k2);
        return result;
    }

    public void helper(ArrayList<Integer> result, TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            helper(result, root.left, k1, k2);
        }
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        if (root.val < k2) {
            helper(result, root.right, k1, k2);
        }
    }
}
