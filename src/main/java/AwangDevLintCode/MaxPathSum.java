package AwangDevLintCode;

/**
 * Created by hadoop on 20/1/18.
 */
/*
singlePath = max(singlePath, 0). This operation already eliminates the negative possibility of a path.
     3
  /     \
7      -1
singlePath = max(-1, 0) = 0
maxPath = max(7, 7 + 3 + 0) = 10
Typical divide and conquer problem.
It is possible that a single path of left subtree or right subtree has a larger sum, or it is possible that a path from left subtree -> root -> right subtree has a larger sum. The problem doesn't specify the value of the nodes, so it's possible that some nodes contain negative values. Thus, we need to track the both the maximum path and single path for each subtree.

SinglePath tracks the maximum sum that can be passed to the parent node for another path that leads to a larger sum. If the singlePath results in negative number, we assume there is no path from this node that can lead to a larger sum (reset to zero).
MaximumPath tracks the maximum sum of current tree / subtree. It is the larger value between left subtree and right subtree, if the root is negative, or the sum of a single path from left to right plus root.
 */
public class MaxPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class MaxPath
    {
        public int maxPathSum(TreeNode root) {
            ResultType rst = Helper(root);
            return rst.maxPath;
        }

        private class ResultType
        {
            int singlePath;
            int maxPath;
            public ResultType(int singlePath, int maxPath)
            {
                this.singlePath = singlePath;
                this.maxPath = maxPath;
            }
        }

        private ResultType Helper(TreeNode root)
        {
            if (root == null)
                return new ResultType (0, Integer.MIN_VALUE);

            //divide
            //traverse the left tree
            ResultType left = Helper(root.left);
            //traverse the right tree
            ResultType right = Helper(root.right);

            //Conquer
            //Choose the maximum single path between left subtree and right subtree
            int singlepath = Math.max(left.singlePath, right.singlePath) + root.val;
            //in case node values are negative, keep the minimum number of nodes as possible
            singlepath = Math.max(0, singlepath);
            //choose the larger between left and right
            int maxpath = Math.max(left.maxPath, right.maxPath);
            //if a path from left to right in the subtree has larger sum than a single subtree path
            maxpath = Math.max(maxpath, left.singlePath + root.val + right.singlePath);

            return new ResultType(singlepath, maxpath);
        }
    }
}
