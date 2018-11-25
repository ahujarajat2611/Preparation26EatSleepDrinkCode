package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
Recover Binary Search Tree
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means?
Update, actually, just do in order traversal.

Consider this wrong BST:

       1
    /      \
  2        3

When we go down to the bottom, we know the left child should be smaller than root, which gives us the first wrong element, lastElement, 2. And now we have the firstElement, and the second element is then the root.


If there is a wrong element in a BST. It means the element must have a larger value compare to it's right child or a smaller value compare to it's left child.
When we traverse down to the left leaf, the last node we visited must have a larger value, assuming we have a correct tree, if it has a smaller value compare to the root, the last node is a wrong element. The same as we traverse up from the right leaf.
When we traverse down to the right leaf, the last node we visited must have a smaller value compare to the root,  if it has a larger value, the root must be a wrong element.
 */


    public class RecoverBST {
        TreeNode firstElement = null;
        TreeNode secondElement = null;
        TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);
        public void recoverTree(TreeNode root) {
            if (root == null)
                return;
            traverse(root);
            swap(firstElement, secondElement);

        }
        private void traverse(TreeNode root)
        {
            if (root == null)
                return;
            traverse(root.left);
            if (firstElement == null && root.val < lastElement.val)
                firstElement = lastElement;
            if (firstElement != null && root.val < lastElement.val)
                secondElement = root;
            lastElement = root;
            traverse(root.right);
        }
        private void swap(TreeNode n1, TreeNode n2)
        {
            int tmp = n1.val;
            n1.val = n2.val;
            n2.val = tmp;
        }
    }


