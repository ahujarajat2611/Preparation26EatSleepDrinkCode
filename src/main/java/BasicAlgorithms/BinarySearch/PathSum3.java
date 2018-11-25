package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 4/3/18.
 */
public class PathSum3 {
    private int getPathSum(TreeNode root, int sum) {
        int rst = 0;
        if (root == null) {
            return rst;
        }
        if (sum == 0) {
            rst = rst + 1;
        }
        if(root.left!=null){
            rst += getPathSum(root.left, sum - root.left.val);
        }
        if(root.right!=null){
            rst += getPathSum(root.right, sum - root.right.val);
        }
        return rst;
    }
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return getPathSum(root, sum-root.val) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
}
