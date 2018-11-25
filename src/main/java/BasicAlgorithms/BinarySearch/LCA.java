package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 3/9/17.
 */
public class LCA {

    TreeNode LowestCommonAncestor(TreeNode root,TreeNode node1,TreeNode node2){

        if(root == null || root == node1 || root == node2){
            return root;
        }

        TreeNode left = LowestCommonAncestor(root.left,node1,node2);
        TreeNode right = LowestCommonAncestor(root.right,node1,node2);

        if(left !=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }
        return null;
    }


    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }
}
