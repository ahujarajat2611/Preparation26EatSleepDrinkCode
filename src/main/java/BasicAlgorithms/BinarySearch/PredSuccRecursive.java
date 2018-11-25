package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class PredSuccRecursive {

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null){
            return null;
        }
        if(root == p){
            return successor(root.right,p);
        }
        else if(p.val<root.val){
            TreeNode left = successor(root.left,p);
            if(left==null){
                return root;
            }
            return left;
        }
        else {
            TreeNode right = successor(root.right,p);
            return right;
        }
    }
    public TreeNode predecessor(TreeNode root, TreeNode p) {

        if(root == null){
            return null;
        }
        if(root == p){
            TreeNode left = predecessor(root.left,p);
            return left;
        }
        if(p.val < root.val){
            TreeNode left = predecessor(root.left,p);
        }
        else{
            TreeNode right = predecessor(root.right,p);
            // it means we found pred in the down tree just return that
            // from function ..
            //
            if(right!=null){
                return right;
            }
            return root;
        }
        return null;
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
