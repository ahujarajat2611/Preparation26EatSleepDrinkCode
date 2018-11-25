package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class InorderSucc {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode beforeRightTurnsave = null;
        while (root!=null){
            if(root.val>p.val){
                beforeRightTurnsave = root;
                root = root.left;
            }
            else if(root.val<p.val) {
                root = root.right;
            }
            else {
                if (p.right!=null){
                    return leftmost(p.right);
                }
                else {
                    return beforeRightTurnsave;
                }
            }
        }
        return null;
    }

    private TreeNode leftmost(TreeNode right) {
        while (right.left!=null){
            right = right.left;
        }
        return right;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}