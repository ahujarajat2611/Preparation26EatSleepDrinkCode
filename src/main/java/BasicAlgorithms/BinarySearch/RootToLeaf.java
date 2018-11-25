package BasicAlgorithms.BinarySearch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 17/10/17.
 */
public class RootToLeaf {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        AtomicInteger integer = new AtomicInteger();
         sumnumberhelper(root,root.val,integer);
        return integer.intValue();
    }
    // top down approach it is

    private void sumnumberhelper(TreeNode root, int val,AtomicInteger integer) {
        if(root == null){
            return ;
        }
        if(root.left== null && root.right == null){
            integer.set(integer.get()+val+root.val);
            return;
        }
        if(root.left!=null) {
            sumnumberhelper(root.left,10*val,integer);
        }
        if(root.right!=null){
            sumnumberhelper(root.right,10*val,integer);
        }

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