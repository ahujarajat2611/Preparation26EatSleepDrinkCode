import javax.swing.tree.TreeNode;

/**
 * Created by hadoop on 4/9/17.
 */
public class BinaryTreeBalanced {
    public boolean isBalanced(TreeNode root){
        return diffHeight(root)!=-1;
    }

    private int diffHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        // if hiegh diff is more than 1 return -1 andd if left oright gets -1
        // then keep returning -1
        int leftHeight = diffHeight(root.left);
        int rightHeight = diffHeight(root.right);
        if(leftHeight == -1 || rightHeight == -1 ||
                // very imp contion to return -1
                // post order traveral
                Math.abs(leftHeight-rightHeight)>1){
            return  -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }
    public int maxdepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = maxdepth(node.left);
        int right = maxdepth(node.right);
        return Math.max(left,right)+1;
    }
}

class IsValidBinarySearchTree{
    boolean firstValue = true;
    private int lastvalue = Integer.MIN_VALUE;

    boolean IsValidBinarySearchTreeHelper(TreeNode node){
        if(node == null) {
            return true;
        }
        boolean left = IsValidBinarySearchTreeHelper(node.left);
        if(firstValue){
            lastvalue = node.data;
            firstValue = false;
        }
        else{
            if(node.data<lastvalue){
                return false;
            }
            lastvalue = node.data;
        }
        if(!left){
            return false;
        }
        return IsValidBinarySearchTreeHelper(node.right);
    }


    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }

}