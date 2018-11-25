package BasicAlgorithms.BinarySearch;

import java.util.Stack;

/**
 * Created by hadoop on 18/10/17.
 */
public class Flatten {
    // will not work .. use recursion stack .. Really nice it is
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(0);
        TreeNode head = dummy;
        TreeNode node = root;

        while (true){
            while (node!=null){

                head.right = root;
                head = head.right;
                stack.push(node);
                node = node.left;
            }
            TreeNode popped = stack.pop();
            node = popped.right;
        }
    }

    public TreeNode flattenRecursion(TreeNode root){
     Noderef head = new Noderef();
     head.node = null;
     TreeNode savehead = head.node;
     flattenRecursionHelper(root,head);
     return savehead;
    }

    private void flattenRecursionHelper(TreeNode root, Noderef lastvisitnode) {
        if(root == null){
            return;
        }
        TreeNode realRight = root.right;
        if(lastvisitnode.node == null){
            lastvisitnode.node = root;
        }
        else {
            lastvisitnode.node.right = root;
            lastvisitnode.node= root;
        }
        flattenRecursionHelper(root.left,lastvisitnode);
        flattenRecursionHelper(realRight,lastvisitnode);
    }

    private class Noderef{
        TreeNode node;
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val = x;
        }
    }
}