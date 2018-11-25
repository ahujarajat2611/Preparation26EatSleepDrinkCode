package BasicAlgorithms.BinaryTree;

import smallmomentsmakeitbigger26.TreeNode;

/**
 * Created by hadoop on 25/12/17.
 */
public class LeftMostValueInTree {

    int maxD, ans;

    public int findLeftMostNode(TreeNode root) {
        ans = maxD = -1;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) return;
        if (d > maxD) {
            maxD = d;
            ans = root.val;
        }
        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }

}
