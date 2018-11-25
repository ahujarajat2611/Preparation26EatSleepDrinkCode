/**
 * 
 */
package DSA.trees.bst;


import DSA.nodes.BinaryTreeNode;

import static DSA.trees.binary.BinaryTree.isLeaf;

/**
 * @author Raj
 *
 */
public class RemoveAllHalfNodes {

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
		tree.postOrder(tree.root);
		System.out.println();
		RemoveAllHalfNodes obj = new RemoveAllHalfNodes();

		// Time :O(n)
		// using post-order traversal
		tree.root = obj.removeAllHalfNodes(tree.root);
		tree.postOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);

	}

	public BinaryTreeNode<Integer> removeAllHalfNodes(BinaryTreeNode<Integer> root) {
		if (root == null)
			return null;
		root.left = removeAllHalfNodes(root.left);
		root.right = removeAllHalfNodes(root.right);
		// we have to do this question
		// postoder way !!! Just cant do it preporde wise !!!

		if (isHalfNode(root)) {
			return root.left != null ? root.left : root.right;
		}
		return root;
	}

	public boolean isHalfNode(BinaryTreeNode<Integer> root) {
		return (root.left != null && root.right == null) || (root.left == null && root.right != null);
	}

	public BinaryTreeNode<Integer> removeAllHalfNodesMIne(BinaryTreeNode<Integer> root) {
		if (root == null)
			return null;
		if(isLeaf(root)){
			return root;
		}
		root.left = removeAllHalfNodes(root.left);
		root.right = removeAllHalfNodes(root.right);
		// we have to do this question
		// postoder way !!! Just cant do it preporde wise !!!
		if(root.left == null && root.right!=null){
			return root.right;
		}
		if(root.right == null && root.left !=null){
			return root.left;
		}
//		if (isHalfNode(root)) {
//			return root.left != null ? root.left : root.right;
//		}
		return root;
	}

}
