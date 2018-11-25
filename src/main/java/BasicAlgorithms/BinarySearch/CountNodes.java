package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 17/10/17.
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftheight = leftheight(root);
        int rightheight = rightheight(root);
        if(leftheight == rightheight){
            return 1>>(leftheight) -1;
        }
        else {
            return 1 + countNodes(root.left)+countNodes(root.right);
        }
    }

    private int leftheight(TreeNode root) {
        int x = 1;
        while (root!=null){
            root = root.left;
            x++;
        }
        return x;
    }
    private int rightheight(TreeNode root) {
        int x = 1;
        while (root!=null){
            root = root.left;
            x++;
        }
        return x;
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
