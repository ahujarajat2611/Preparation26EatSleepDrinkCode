package AwangDevLintCode;

/**
 * Created by hadoop on 5/2/18.
 */
import java.util.*;
public class LowestCommonAncestorBST {

    /*
    Thoughts:
    Besides the method of finding all ancestors, we can look at the problem in a greedy way.
    Move both p and q to find the ancestor:
    If the root is on the left of both p and q, that means the ancestor must be on right size of root; same applies to the other direction.

    This leads to a compact recursive solution.

    However, the iterative way might be more useful in real development where it utilize data struture
    */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return root;
            }
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            return root;
        }

    /*
    Thoughts:
    Based on the value of p and q,
     use BST to find the node, and store the visited nodes in two separate lists.
    Find last common item in the list to return.
    */
    public TreeNode lowestCommonAncestorDifficultAnddLOngfddfae(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        final List<TreeNode> listP = new ArrayList<>();
        final List<TreeNode> listQ = new ArrayList<>();
        findNode(root, p, listP);
        findNode(root, q, listQ);
        int size = listP.size() > listQ.size() ? listQ.size() : listP.size();
        TreeNode parent = root;
        for (int i = 0; i < size; i++) {
            if (listP.get(i).val == listQ.get(i).val) {
                parent = listP.get(i);
            } else {
                return parent;
            }
        }
        return parent;
    }

    private void findNode(TreeNode node, TreeNode target, List<TreeNode> list) {
        while (node != null) {
            list.add(node);
            if (node.val == target.val) {
                return;
            }
            if (node.val > target.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

/*
Thoughts:
Besides the method of finding all ancestors, we can look at the problem in a greedy way.
Move both p and q to find the ancestor:
If the root is on the left of both p and q, that means the ancestor must be on right size of root; same applies to the other direction.

This leads to a compact recursive solution.

However, the iterative way might be more useful in real development where it utilize data struture
*/

}
