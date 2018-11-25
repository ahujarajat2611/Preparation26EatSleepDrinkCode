package OldAttemptLearning.programgreek;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by hadoop on 22/8/17.
 */
public class BSTIterator implements Iterator<Integer> {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode treeNode) {
        while (treeNode!=null){
            stack.push(treeNode);
            treeNode = treeNode.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {

        TreeNode treeNode = stack.pop();
        int value = treeNode.val;
        if(treeNode.right!=null){
            treeNode = treeNode.right;
        }
        while (treeNode!=null){
            stack.push(treeNode);
            treeNode = treeNode.left;
        }
        return value;
    }
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
}
