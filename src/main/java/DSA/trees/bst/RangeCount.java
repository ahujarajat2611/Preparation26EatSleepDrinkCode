/**
 * 
 */
package DSA.trees.bst;


import DSA.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class RangeCount {

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
		tree.inOrder(tree.root);
		System.out.println();
		RangeCount obj = new RangeCount();

		int k1 = 10, k2 = 20;
		obj.rangeCount(tree.root, k1, k2);
		System.out.println(obj.count);

		RangeCount obj2 = new RangeCount();
		obj.rangeCountMine(tree.root,k1,k2);
		System.out.println(obj.count);

	}

	int count = 0;

	// k1 < k2
	public void rangeCount(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (null == root)
			return;
		if (root.data >= k1)
			rangeCount(root.left, k1, k2);

		if (root.data >= k1 && root.data <= k2)
			count++;

		if (root.data <= k2)
			rangeCount(root.right, k1, k2);
	}

	public void rangeCountMine(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (null == root)
			return;
		if (root.data < k1) {
			rangeCountMine(root.right, k1, k2);
			return;
		}

		if (root.data >= k1 && root.data <= k2)
			count++;

		if (root.data > k2) {
			rangeCountMine(root.left, k1, k2);
			return;
		}
		rangeCountMine(root.left, k1, k2);
		rangeCountMine(root.right, k1, k2);
	}

}
