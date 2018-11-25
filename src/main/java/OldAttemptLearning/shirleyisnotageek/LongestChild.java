package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
Use top-down approach would be easier. Parse the last value (parent value), current path and maximum path to each recursion. If lastVal + 1 = root.val, path++, otherwise path resets to 1. Maximum path is the maximum path of current path, left child path and right child path.
 */
public class LongestChild {
    public int longestConsecutive(TreeNode root) {
        return getPath(root, root.val - 1, 0, 0);
    }

    private int getPath(TreeNode root, int lastVal, int path, int max) {
        if (root == null) {
            return 0;
        }
        path = lastVal + 1 == root.val ? path + 1 : 1;
        max = Math.max(max, path);
        int left = getPath(root.left, root.val, path, max);
        int right = getPath(root.right, root.val, path, max);
        return Math.max(max, Math.max(left, right));
    }
}
