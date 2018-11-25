package DSA.trees.bst;

import DSA.nodes.BinaryTreeNode;

/**
 * Created by hadoop on 22/2/18.
 */
public class ConvertBstToMaxSumKeys {
    int sum =0;
    public void convertBSTtoBinaryTreeWithSumOfMaxKeys(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        convertBSTtoBinaryTreeWithSumOfMaxKeys(root.right);
        sum += root.data;
        root.data = sum;
        convertBSTtoBinaryTreeWithSumOfMaxKeys(root.left);
    }
}
