package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class HouseRobbery3 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            // return 0,0
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
//0 means excluding
        //
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 1 means include
// if included means we need to fetch excluded elements
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
