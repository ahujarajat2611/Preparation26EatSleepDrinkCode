/**
 *
 */
package DSA.trees.bst;


import DSA.nodes.BinaryTreeNode;

/**
 * @author Raj
 */
public class PruneBSTOutsideRange {

    // k1 < k2

    public BinaryTreeNode<Integer> pruneBST(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (null == root) {
            return root;
        }
        if (root.data < k1) {
            return pruneBST(root.right, k1, k2);
        }
        if (root.data > k2) {
            return pruneBST(root.left, k1, k2);
        }

        root.left = pruneBST(root.left, k1, k2);
        root.right = pruneBST(root.right, k1, k2);
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 13);
        tree.inOrder(tree.root);
        System.out.println();
        PruneBSTOutsideRange obj = new PruneBSTOutsideRange();

        // remove keys from bst if they are not in the ranges

        int k1 = 10, k2 = 15;
        tree.root = obj.pruneBST(tree.root, k1, k2);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();

    }

}
