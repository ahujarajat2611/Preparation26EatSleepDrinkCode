package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note
You may assume that duplicates do not exist in the tree.

Example
Given inorder [1,2,3] and postorder [1,3,2]

return a tree

  2
 /  \
1    3


Tags Expand
Binary Tree

Thinking process:
Know that the last element of PostOrder
array is the root of the Binary tree.
Find this root from the InOrder array.
The front-part of the inorder array will be left-tree,
 the end-part of the inorder array will be the right-tree.
Trick part:
1. Need a helper function to perfrom divide/conquer.
2. Need to be careful when cutting the inorder and postorder array.
    For inorder array, left array:
    (instart, middlePosition -1), right array:
    (middlePosition + 1, inend)
    For postorder array: when cutting,
     we know the very last node is cut off already,
     so we just need to evenly split the rest array.
        left array(postStart, postStart + (middlePosition - instart) - 1).
            Note: (middlePositon - instart) means the length of the left-array/size of the left-tree
            However, postStart + left-array-length exceed 1 over postorder-left-tree, hence minus 1 here.
        right array(postStart + (middlePosition - instart),   postend - 1)
            Note: postStart + left-tree-length is exactly the starting point of the post-right-array.
            Because the ending element is cut off previously to serve as root, we need to do (postend - 1) for correct postorder-right-tree.

*/
public class TreeFromPostOrderInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                    int[] postorder, int postStart, int postEnd){
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int mid = findMid(inorder, inStart, inEnd, postorder[postEnd]);
        root.left = buildTreeHelper(inorder, inStart, mid - 1,
                postorder, postStart, postStart + (mid - inStart) - 1);
        root.right = buildTreeHelper(inorder, mid + 1, inEnd,
                postorder, postStart + (mid - inStart), postEnd - 1);
        return root;
    }

    public int findMid(int[] arr, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTreeInorderPreorder(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        return buildTreeHelperInorderPreorder(inorder, 0, inorder.length - 1,
                preorder, 0, preorder.length - 1);
    }

    public TreeNode buildTreeHelperInorderPreorder(int[] inorder, int inStart, int inEnd,
                                    int[] preorder, int preStart, int preEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int mid = findMid(inorder, inStart, inEnd, preorder[preStart]);

        root.left = buildTreeHelperInorderPreorder(inorder, inStart, mid - 1,
                preorder, preStart + 1, preStart + (mid - inStart));
        root.right = buildTreeHelperInorderPreorder(inorder, mid + 1, inEnd,
                preorder, preStart + (mid - inStart) + 1, preEnd);
        return root;
    }

}
