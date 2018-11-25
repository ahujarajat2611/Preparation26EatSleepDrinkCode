package BasicAlgorithms.BinaryTree;

/**
 * Created by hadoop on 24/10/17.
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key<root.val){
            root.left = deleteNode(root.left,key);
        }
        else if(key>root.val){
            root.right = deleteNode(root.right,key);
        }
        else {
            if(root.left!=null && root.right!=null){
                int min = successor(root.right);
                root.val = min;
                root.right = deleteNode(root.right,min);
            }
            else {
                /// very imp point to undesrabe
                if(root.left == null && root.right!=null){
                    return root.right;
                }
                else {
                    return root.left;
                }
            }
        }
        return root;
    }

    private int successor(TreeNode right) {
        while (right.left!=null){
            right = right.left;
        }
        return right.val;
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
