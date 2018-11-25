package OldAttemptLearning.shirleyisnotageek;


/*
Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes.

Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.
 */


/*
A very beautiful Tree reverse problem from Careercup.

1. Traverse down to the left bottom of the tree, make it as the new root.
2. Recursively going up and reverse the tree.

    1
  /    \
2      3

root .val == 1;
newRoot = 2;
root.left.left ( 1.left.left = 2.left) = root.right (3)
root.left.right (1.left.right = 2.right) = root (1);
root.left = null
root.right = null
    2
  /    \
3      1

Update: 2015 - 01 - 02

The left leaf node will be returned as the NEW root, thus every time we need to change the pointers of the ORIGINAL root.
Technically it's possible to have a condition like this:
   2
 /    \
3     1
  \
    4
Since the problem doesn't say a left leaf node must exist...
Anyway, let's assume if this situation happens, take the node 3 as the new root and discard the poor 4...


 /* for example, turn these:
 *
 *        1                 1
 *       / \                 / \
 *      2   3            2   3
 *     / \
 *    4   5
 *   / \
 *  6   7
 *
 * into these:
 *
 *        1               1
 *       /               /
 *      2---3         2---3
 *     /
 *    4---5
 *   /
 *  6---7
 *
 * where 6 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *     6                   2
 *    / \                   / \
 *   7   4              3   1
 *        / \
 *       5   2
 *            / \
 *          3   1
 */


public class BTUpsideDown {
 public TreeNode upsideDown(TreeNode root)
 {
  if (root == null)
   return root;
  if (root.left == null || root.right == null)
   return root;
  //traverse down to the left leave
  TreeNode newRoot = upsideDown(root.left);
  root.left.left = root.right;
  root.left.right = root;
                //root becomes leaf
  root.left = null;
  root.right = null;
  //System.out.println(newRoot.val);
  return newRoot;
 }
}