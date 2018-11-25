package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
If the node has a right child, no doubt the successor should be the left most children of its right child. Otherwise, either the node is the right most node which does not have a successor or it is a left child of some node. In both case, we can traverse the tree, whenever we find the node is smaller than the root, we set the successor to the root of the node and proceed to check its left child until we find the node.
 */
public class Successor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null) {
            return null;
        }
        if (p.right != null) {
            return leftMost(p.right);
        }
        TreeNode suc = null;
        while (root != null) {
            if (p.val < root.val) {
                suc = root;
                root = root.left;
            } else if (p.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return suc;
    }

    private TreeNode leftMost(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
