package BasicAlgorithms.BinarySearch;

import java.util.*;
/**
 * Created by hadoop on 16/1/18.
 */
public class FirstLeafNonMatching {
    public int[] firstPairNoMatchingNodes (TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return new int[]{-1, -1};
        }
        Stack<TreeNode> tree1 = new Stack<>();
        Stack<TreeNode> tree2 = new Stack<>();
        getLeaves(r1, tree1);
        getLeaves(r2, tree2);

        TreeNode leaf1 = getLeaf(tree1);
        TreeNode leaf2 = getLeaf(tree2);
        while (leaf1 != null && leaf2 != null) {
            if (leaf1.val != leaf2.val) {
                return new int[]{leaf1.val, leaf2.val};
            }
            leaf1 = getLeaf(tree1);
            leaf2 = getLeaf(tree2);
        }
        return new int[]{-1, -1};
    }

    private void getLeaves(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    private TreeNode getLeaf(Stack<TreeNode> tree) {
        while (!tree.isEmpty()) {
            TreeNode curr = tree.pop();
            if (curr.left == null && curr.right == null) {
                return curr;
            } else if (curr.right != null) {
                getLeaves(curr.right, tree);
            }
        }
        return null;
    }
}
