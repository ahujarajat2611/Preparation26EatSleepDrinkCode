package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
Find Leaves of Binary Tree
Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.
Example:
Given binary tree
          1
         / \
        2   3
       / \
      4   5
Returns [4, 5, 3], [2], [1].
Explanation:
1. Remove the leaves [4, 5, 3] from the tree
          1
         /
        2
2. Remove the leaf [2] from the tree
          1
3. Remove the leaf [1] from the tree
          []
Returns [4, 5, 3], [2], [1].

The most straightforward way is that, for each level, find leaves and remove those leaves, until we reach root. However, the complexity of this approach is extremely high. A better way is to track the depth of each level. If a node has no child, its a leave, and we assign its depth to 0. Now for each inner node, we first recursively find the max depth between its left and right child, then we calculate its depth by adding the maximum by 1. After we have the depth, we know where to add the node in the list.

The most straightforward way is that, for each level, find leaves and remove those leaves, until we reach root. However, the complexity of this approach is extremely high. A better way is to track the depth of each level. If a node has no child, its a leave, and we assign its depth to 0. Now for each inner node, we first recursively find the max depth between its left and right child, then we calculate its depth by adding the maximum by 1. After we have the depth, we know where to add the node in the list.

 */
public class FindLeavesBinaryTree {
    public List<List<Integer>> findLeaves (TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        findLeaves(root, rst);
        return rst;
    }

    private int findLeaves(TreeNode root, List<List<Integer>> rst) {
        if (root == null) {
            return -1;
        }
        int depth = 1 + Math.max(findLeaves(root.left, rst), findLeaves(root.right, rst));
        if (depth >= rst.size()) {
            rst.add(new ArrayList<>());
        }
        rst.get(depth).add(root.val);
        return depth;
    }
}
