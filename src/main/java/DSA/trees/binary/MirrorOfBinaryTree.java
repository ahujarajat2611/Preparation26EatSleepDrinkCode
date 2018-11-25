/**
 * 
 */
package DSA.trees.binary;

import DSA.nodes.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author Raj
 *
 */
public class MirrorOfBinaryTree {

	public boolean areMirrors(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		return root1.data == root2.data && areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MirrorOfBinaryTree obj = new MirrorOfBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);

		BinaryTree ob2 = new BinaryTree();
		ob2.insert(1);
		ob2.insert(3);
		ob2.insert(2);
		ob2.insert(7);
		ob2.insert(6);
		ob2.insert(5);
		ob2.insert(4);

		ob.inOrder(ob.root);
		System.out.println();
		ob2.inOrder(ob2.root);
		System.out.println();

		obj.mirrorWithoutRecursion(ob.root);
		ob.inOrder(ob.root);
		System.out.println();

		obj.mirror(ob.root);
		ob.inOrder(ob.root);
		System.out.println();

		boolean result = obj.areMirrors(ob.root, ob2.root);
		System.out.println(result);

		BinaryTree ob3 = new BinaryTree();
		ob3.insert(1);
		ob3.insert(2);
		ob3.insert(2);
		ob3.insert(3);
		ob3.insert(4);
		ob3.insert(4);
		ob3.insert(3);
		ob3.levelOrder(ob3.root);
		System.out.println(obj.isSymmetric(ob3.root));
	}

	public boolean isSymmetric(BinaryTreeNode<Integer> root) {
		if (null == root)
			return true;
		return areMirrors(root.left, root.right);
	}

	public void mirror(BinaryTreeNode<Integer> root) {
		if (null == root)
			return;
		mirror(root.left);
		mirror(root.right);
		swapLeftRight(root);
	}

	public void mirrorWithoutRecursion(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> cur;
		queue.addLast(root);

		while (!queue.isEmpty()) {
			cur = queue.removeFirst();
			if (cur.left != null)
				queue.addLast(cur.left);
			if (cur.right != null)
				queue.addLast(cur.right);
			swapLeftRight(cur);
		}
	}
	public static BinaryTreeNode<Integer> swapLeftRight(BinaryTreeNode<Integer> cur) {
		BinaryTreeNode<Integer> temp = cur.left;
		cur.left = cur.right;
		cur.right = temp;
		return cur;
	}

}
