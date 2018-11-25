package DSA.trees.bst;

import DSA.nodes.BinaryTreeNode;

import static java.lang.Math.abs;


/**
 * 
 * @author Raj
 *
 *         Given a non-empty binary search tree and a target value, find the
 *         value in the BST that is closest to the target.
 * 
 *         Note: Given target value is a floating point. You are guaranteed to
 *         have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {

	public int closestValue(BinaryTreeNode<Integer> root, double target) {
		BinaryTreeNode<Integer> closest = root;
		while (root != null) {
			if (abs(root.data - target) < abs(closest.data - target)) {
				closest = root;
			}
			//OMG
			// YOU HAD GOT CONFUSED HERE !!!
			// NOT SURE WHY !!!
			// if target <root.data then you need to go to left to go nearer to the taregt not right to go away from target
			root = root.data > target ? root.left : root.right;
		}
		return closest.data;
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

		ClosestBinarySearchTreeValue obj = new ClosestBinarySearchTreeValue();
		double target = 4.428571;

		int result = -1;
		result = obj.closestValue(tree.root, target);
		System.out.println(result);
	}

}
