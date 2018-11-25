package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class UpsideDown {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return root;
            }
            //每次返回的newRoot
            TreeNode newRoot = upsideDownBinaryTree(root.left);
            //每次迭代的将当前root的right结点 赋值给下面left孩子的 right节点，
            //将root赋值给下面left孩子的left结点，然后设置root.left , root.right
            root.left.left = root.right;//该节点的父亲节点的右节点为该节点的左孩子
            root.left.right = root;//该节点的父亲节点为该节点的右孩子
            root.left = null;//父节点的左右孩子设空
            root.right = null;//父节点的左右孩子设空
            //依然返回root结点
            return newRoot;

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
