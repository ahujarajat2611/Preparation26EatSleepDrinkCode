package BasicAlgorithms.BinarySearch;

import java.util.Stack;

/**
 * Created by hadoop on 18/10/17.
 */
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushleftvalues(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode popped = stack.pop();
        int val = popped.val;
        pushleftvalues(popped.right);
        return val;
    }
    private void pushleftvalues(TreeNode node){
        while (node!=null){
            stack.push(node);
            node = node.left;
        }
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int  val;
        TreeNode( int val){
            this.val = val;
        }
    }
}
