package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if(root== null){
            return -1;
        }
        int numberOfElements = count(root.left);

        if(numberOfElements == k){
            return root.val;
        }
        else if(numberOfElements<k){
            return kthSmallest(root.right,k-numberOfElements);
        }
        else {
            return kthSmallest(root.left,k);
        }
    }

    private int count(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+ count(root.left)+count(root.right);
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val = x;
        }
    }
}