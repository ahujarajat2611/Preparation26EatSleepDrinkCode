package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 17/10/17.
 */
public class SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (t == null){
            return false;
        }
        if (s == null){
            return false;
        }
        //
        return issame(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }


    public boolean issame(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null){
            return false;
        }
        if(s!= null && t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return issame(s.left,t.left) && issame(s.right,t.right);
    }
    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}