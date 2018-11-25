package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
Flatten Binary Tree to Linked List

Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
Note
Don't forget to mark the left child of each node to null.
Or you will get Time Limit Exceeded or Memory Limit Exceeded.

 */
public class FlattenBinaryTreeToLinkedList {
    public TreeNode parentNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (parentNode != null) {
            parentNode.left = null;
            parentNode.right = root;
        }

        parentNode = root;
        TreeNode right  = root.right;
        flatten(root.left);
        flatten(right);
    }
}
