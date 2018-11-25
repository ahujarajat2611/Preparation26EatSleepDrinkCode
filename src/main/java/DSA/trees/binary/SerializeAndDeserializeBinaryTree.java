/**
 * 
 */
package DSA.trees.binary;


import DSA.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
import java.util.*;
public class SerializeAndDeserializeBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		BinaryTree.inOrder(ob.root);
		System.out.println();
		StringBuilder preOrder = new StringBuilder();
		obj.serializeBinaryTree(ob.root, preOrder);
		System.out.println(preOrder);
		BinaryTreeNode<Integer> root = null;
		root = obj.deSerializeBinaryTree(preOrder);
		BinaryTree.inOrder(root);
	}

	int index = 0;

	public BinaryTreeNode<Integer> deSerializeBinaryTree(StringBuilder preOrder) {
		char ch = preOrder.charAt(index++);
		if (ch == '#') {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(Character.getNumericValue(ch));
		root.left = deSerializeBinaryTree(preOrder);
		root.right = deSerializeBinaryTree(preOrder);
		return root;
	}

	// use List<String> to capture tree. If negative numbers or two digit
	// numbers are there string concatenation may not work
	public void serializeBinaryTree(BinaryTreeNode<Integer> root, StringBuilder preOrder) {
		if (null == root) {
			preOrder.append("#");
			return;
		}
		preOrder.append(root.data);
		serializeBinaryTree(root.left, preOrder);
		serializeBinaryTree(root.right, preOrder);
	}
	public boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.length() == 0) {
			return true;
		}

		String[] nodes = preorder.split(",");
		Stack<String> stack = new Stack<>();

		for (String node : nodes) {
			if (node.equals("#")) {
				while (!stack.isEmpty() && stack.peek().equals("#")) {
					stack.pop();
					if (stack.isEmpty()) {
						return false;
					}

					stack.pop();
				}
			}

			stack.push(node);
		}

		return stack.size() == 1 && stack.peek().equals("#");
	}

}
