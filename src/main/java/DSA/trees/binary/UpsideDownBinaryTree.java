package DSA.trees.binary;


import DSA.nodes.BinaryTreeNode;

public class UpsideDownBinaryTree {

	public BinaryTreeNode<Integer> upsideDown(BinaryTreeNode<Integer> root) {
		if (null == root || null == root.left) {
			return root;
		}

		BinaryTreeNode<Integer> newRoot = upsideDown(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		return newRoot;
	}

	public BinaryTreeNode<Integer> upsideDown2(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> prev) {
		if (null == root) {
			return root;
		}
		if (root.left != null) {
			BinaryTreeNode<Integer> newRoot = upsideDown2(root.left, root);
			if (prev != null) {
				root.left = prev.right;
				root.right = prev;
			} else {
				root.left = root.right = null;
			}
			return newRoot;
		} else {
			root.left = prev.right;
			root.right = prev;
			return root;
		}
	}

	public static void main(String args[]) {
		UpsideDownBinaryTree obj = new UpsideDownBinaryTree();
		BinaryTreeNode<Integer> root1 = obj.createTestTree1();
		// Traversals.levelOrderWithMarkers(root1);
		// root1 = obj.upsideDown2(root1, null);
		// Traversals.levelOrderWithMarkers(root1);
		// root1 = obj.createTestTree1();
		Traversals.levelOrderWithMarkers(root1);
		root1 = obj.upsideDown(root1);
		Traversals.levelOrderWithMarkers(root1);

	}

	private BinaryTreeNode<Integer> createTestTree1() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
//		n4.left = n6;
//		n4.right = n7;
		return n1;
	}

	private BinaryTreeNode<Integer> createTestTree2() {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);

		n1.left = n2;
		n1.right = n3;
		return n1;
	}



	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		return upsideDownBinaryTreeHelper(root, null);
	}

	private TreeNode upsideDownBinaryTreeHelper(TreeNode root, TreeNode parent) {
		if (root == null ) {
			return parent;
		}

		TreeNode newNode = upsideDownBinaryTreeHelper(root.left, root);
		if(parent !=null){
			root.left =parent.right;
		}
		else{
			root.left = null;
		}
		root.right = parent;

		return newNode;
	}

	private TreeNode upsideDownBinaryTreeHelperAgain(TreeNode root, TreeNode parent) {
		if (root .left== null ) {
			return root;
		}

		TreeNode newNode = upsideDownBinaryTreeHelper(root.left, root);
		if(parent !=null){
			root.left =parent.right;
		}
		else{
			root.left = null;
		}
		root.right = parent;

		return newNode;
	}

	/// we can write reversal linkedlist code as well this way

}
