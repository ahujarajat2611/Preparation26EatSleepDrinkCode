package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 24/10/17.
 */
public class Diameter {
    public int diameterOfBinaryTree(TreeNode root) {
        ResultType ans = dfsHelper(root);
        return ans.diameter;
    }

    private ResultType dfsHelper(TreeNode root) {
        if(root == null){
            return new ResultType(0,Integer.MIN_VALUE);
        }
        if(root.left == null && root.right == null){
            return new ResultType(1,1);
        }
        ResultType left = dfsHelper(root.left);
        ResultType right = dfsHelper(root.right);

        int localheight = Math.max(left.height,right.height)+1;
        int diameter = Math.max(Math.max(left.diameter,right.diameter),left.height + right.height +1);
        ResultType resultType = new ResultType(localheight,diameter);
        return resultType;
    }

    private class ResultType{
        int height;
        int diameter;

        public ResultType(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
