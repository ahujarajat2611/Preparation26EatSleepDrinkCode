package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
public class SOrtedArrayToBstMinimalHeight {
    public TreeNode sortedArrayToBST(int[] A) {
        TreeNode root = null;
        if (A == null || A.length == 0) {
            return root;
        }
        root = helper(0, A.length - 1, A);
        return root;
    }

    public TreeNode helper(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        //add middle node
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(A[mid]);
        //Split and append child
        node.left = helper(start, mid - 1, A);
        node.right = helper(mid + 1, end, A);
        return node;
    }
}
