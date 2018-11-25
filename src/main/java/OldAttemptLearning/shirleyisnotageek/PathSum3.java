package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 22/1/18.
 */
public class PathSum3 {
    private int getPathSum(TreeNode root, int sum) {
        int rst = 0;
        if (root == null) {
            return rst;
        }
        if (sum == root.val) {
            rst++;
            return rst;
        }
        rst += getPathSum(root.left, sum - root.val);
        rst += getPathSum(root.right, sum - root.val);
        return rst;
    }
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return getPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static void main(String[] args) {
        PathSum3 pathSum3 = new PathSum3();
    }
}
