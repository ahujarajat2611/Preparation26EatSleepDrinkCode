package BasicAlgorithms.BinarySearch;

import smallmomentsmakeitbigger26.TreeNode;

/**
 * Created by hadoop on 25/12/17.
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
 5
 /   \
 2     13

 Output: The root of a Greater Tree like this:
 18
 /   \
 20     13
 */
public class BstToHIgherSUmValues {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.right);

        int tmpVal = root.val;
        root.val += sum;
        sum += tmpVal;

        dfs(root.left);
    }
}
