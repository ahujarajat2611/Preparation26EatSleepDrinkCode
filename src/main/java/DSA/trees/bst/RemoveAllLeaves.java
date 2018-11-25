/**
 * 
 */
package DSA.trees.bst;


import DSA.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class RemoveAllLeaves {

	/**
	 * @param args
	 */
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
		tree.levelOrder(tree.root);
		RemoveAllLeaves obj = new RemoveAllLeaves();

		// Time :O(n)
		// using pre-order traversal
		tree.root = obj.removeAllLeaves(tree.root);
		tree.levelOrder(tree.root);

	}

	public BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {
		if (root == null)
			return null;
		if (isLeave(root)) {
			root = null;
			return root;
		}
		// normal preoder whise .. if you end up doiing postordertraversal
		// then it can be a big problem
		// you will have ot pass one more flga to let it know that
		// its leav already deleted done delete it surther !!
		// this is much better
		root.left = removeAllLeaves(root.left);
		root.right = removeAllLeaves(root.right);
		return root;
	}

	public boolean isLeave(BinaryTreeNode<Integer> root) {
		return root.left == null && root.right == null;
	}

}
