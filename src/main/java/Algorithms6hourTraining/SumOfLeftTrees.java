package Algorithms6hourTraining;

import smallmomentsmakeitbigger26.TreeNode;

/**
 * Created by hadoop on 21/12/17.
 */
// Tricky it is
// one thing is clear you have look for all options and then keep returning ans from its child
// and keep addiing it ( thats the mantra)
    // asks child to return you the ans you need !!!! and calculate ans at the current node as well !!
public class SumOfLeftTrees {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null){
            return sum;
        }
        if(root.left != null && isLeaf(root.left)){
            sum += root.left.val;
        }
        if(isLeaf(root)){
            return sum; // sum value is zero .....
        }

        return sum + sumOfLeftLeaves(root.right)+sumOfLeftLeaves(root.left);
    }
    /*
      public int sumOfLeftLeaves(BinaryTreeNode<Integer> root) {
        return sumOfLeftLeavesUtil(root,false);
    }
    private int sumOfLeftLeavesUtil(BinaryTreeNode<Integer> root, boolean isLeft) {
        if(null == root)
            return 0;
        if(BinaryTree.isLeaf(root) && isLeft) {
            return root.data;
        }
        return sumOfLeftLeavesUtil(root.left, true)+sumOfLeftLeavesUtil(root.right, false);
    }
     */

    private boolean isLeaf(TreeNode left) {
        if(left.left == null && left.right == null){
            return true;
        }
        return false;
    }
}