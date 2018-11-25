package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Largest BST Subtree
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \
 1   8   7
The Largest BST Subtree in this case is the highlighted one.
The return value is the subtree's size, which is 3.

Hint:
You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
 */
/*
Use a struct which contains current subtree number the and the maximum subtree so far. Recursively get the result from the two children. Now if curr is 0 for either tree, it means the node's children are not valid BST, so we only track the maximum subtree seen so far. Otherwise, if current node and its left and right children follows the BST rule, we update the maximum subtree number and current subtree number.

 */
public class LargestBST {
    public int largestBSTSubtree(TreeNode root) {
        return getTree(root).max;
    }

    private BSTCounter getTree(TreeNode root) {
        if (root == null) {
            return new BSTCounter(0, 0);
        }
        if (root.left == null && root.right == null) {
            return new BSTCounter(1, 1);
        }
        BSTCounter left = getTree(root.left);
        BSTCounter right = getTree(root.right);
        BSTCounter curr = new BSTCounter(0, 0);
        if (left.curr == -1 || right.curr == -1
                || (root.left != null && root.left.val >= root.val)
                || (root.right != null && root.right.val <= root.val)) {
            curr.curr = -1;
            curr.max = Math.max(left.max, right.max);
        } else {
            curr.curr = left.curr + right.curr + 1;
            curr.max = curr.curr;
        }
        return curr;
    }

    private class BSTCounter {
        int curr;
        int max;
        public BSTCounter(int curr, int max){
            this.curr = curr;
            this.max = max;
        }
    }
}
