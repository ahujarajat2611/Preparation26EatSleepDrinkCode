package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 17/10/17.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if( p == null && q == null){
            return true;
        }
        if((p!= null && q == null) || (q!=null && p== null)){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right) && p.val == q.val;

    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}