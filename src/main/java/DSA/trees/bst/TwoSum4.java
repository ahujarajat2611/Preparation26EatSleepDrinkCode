/**
 *
 */
package DSA.trees.bst;

import DSA.nodes.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author Raj
 * 
 *         Given a Binary Search Tree and a target number, return true if there
 *         exist two elements in the BST such that their sum is equal to the
 *         given target.
 * 
 *         Example 1: Input: 5 / \ 3 6 / \ \ 2 4 7
 * 
 *         Target = 9
 * 
 *         Output: True Example 2: Input: 5 / \ 3 6 / \ \ 2 4 7
 * 
 *         Target = 28
 * 
 *         Output: False
 */
// i did nt like the solution rather i will create two iterator class
	// and iterate one by one
public class TwoSum4 {

	public boolean checkPairWithSumK(BinaryTreeNode<Integer> root, int k) {
		if (null == root) {
			return false;
		}

		Deque<BinaryTreeNode<Integer>> stack1 = new LinkedList<>();
		Deque<BinaryTreeNode<Integer>> stack2 = new LinkedList<>();

		BinaryTreeNode<Integer> temp1 = root, temp2 = root;
		BinaryTreeNode<Integer> top1 = null, top2 = null;

		while (true) {
			if (temp1 != null || temp2 != null) {
				while (temp1 != null) {
					stack1.push(temp1);
					temp1 = temp1.left;
				}
				while (temp2 != null) {
					stack2.push(temp2);
					temp2 = temp2.right;
				}
			} else {
				if (stack1.isEmpty() || stack2.isEmpty()) {
					return false;
				}

				top1 = stack1.peek();
				top2 = stack2.peek();

				// we can choose to peek instead of pushing value onto the stack !!!
				if (top1 == top2) {
					return false;
				}
				int sum = top1.data + top2.data;

				if (sum == k) {
					return true;
				}
				if (sum > k) {
					temp2=stack2.pop();
					temp2 = temp2.left;
				} else if (sum < k) {
					temp1 = stack1.pop();
					temp1 = temp1.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.insert(tree.root, 15);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 16);
		tree.root = tree.insert(tree.root, 25);
		tree.inOrder(tree.root);
		System.out.println();
		TwoSum4 obj = new TwoSum4();

		int k = 26;
		boolean res = obj.checkPairWithSumK(tree.root, k);
		System.out.println(res);

		res = obj.checkPairWithSumK(tree.root, 16);
		System.out.println(res);
	}

}
