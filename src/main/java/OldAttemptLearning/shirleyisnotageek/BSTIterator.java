package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
Binary Search Tree Iterator
mplement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Use a stack to store all left child of the tree (pushNode()). When calling next() method, pop() the tail of the stack. If the node has a right child, store all left children of the right child (pushNode(right)).
 */
    public class BSTIterator {

        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<TreeNode> ();
            pushNode(root);

        }
        private void pushNode(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }


        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            if (stack.isEmpty()) {
                throw new Error("All nodes have been visited");
            }
            TreeNode curr = stack.pop();
            if(curr.right != null) {
                pushNode(curr.right);
            }
            return curr.val;
        }
    }
