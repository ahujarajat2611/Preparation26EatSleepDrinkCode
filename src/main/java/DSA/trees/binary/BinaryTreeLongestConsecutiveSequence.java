/**
 * 
 */
package DSA.trees.binary;
import DSA.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 *         Given a binary tree, find the length of the longest consecutive
 *         sequence path.
 * 
 *         The path refers to any sequence of nodes from some starting node to
 *         any node in the tree along the parent-child connections. The longest
 *         consecutive path need to be from parent to child (cannot be the
 *         reverse).
 * 
 *         For example, 1 \ 3 / \ 2 4 \ 5 Longest consecutive sequence path is
 *         3-4-5, so return 3.
 * 
 *         2 \ 3 / 2 / 1 Longest consecutive sequence path is 2-3,not3-2-1, so
 *         return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {

	// Time : O(n), Space : O(n)
	public static int longestConsecutive(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int res[] = new int[1];
		helper(root, root.data, 0, res);
		return res[0];
	}

	private static void helper(BinaryTreeNode<Integer> root, int target, int curCount, int[] res) {
		if (null == root)
			return;

		if (root.data == target) {
			curCount++;
		} else {
			curCount = 1;
		}
		res[0] = Math.max(res[0], curCount);
		helper(root.left, root.data + 1, curCount, res);
		helper(root.right, root.data + 1, curCount, res);
	}

	public static void main(String[] args) {

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(0);
		ob.insert(0);
		ob.insert(4);
		ob.insert(0);
		ob.insert(0);
		ob.insert(0);
		ob.insert(0);
		ob.insert(0);
		ob.insert(5);

		BinaryTree.levelOrder(ob.root);
		int result = -1;
		result = longestConsecutive(ob.root);
		System.out.println(result);

	}

}
//
///*
//package BasicAlgorithms.BinarySearch;
//
///**
// * Created by hadoop on 13/2/18.
// */
//import java.util.*;
//public class MaxPathThatHashConsecutiveElements {
//}
//
////    Binary Tree( increasing by 1 )
////    parent to child ( parent to child)
////root :->
//

//class Tree{
//
//	//int maxAnswer =Integer.MIN_VALUE;
//	List<Integer> maxList = new ArrayList<Integer>();
//	List<Integer> getLongestIncreasingPathFromParentChild(TreeNode root){
//
//		List<Integer> result = new ArrayList<Integer>();
//		if(root == null){
//			return result;
//		}
//		if(isLeaf(root)){
//			result.add(root.val);
//			return result;
//		}
//
//		List<Integer> left = getLongestIncreasingPathFromParentChild(root.left);
//		List<Integer> right = getLongestIncreasingPathFromParentChild(root.right);
//
//		int current  = root.val;
//		int lastLeftValue = left.get(left.size()-1);
//		if(current +1 == lastLeftValue ){
//			left.add(current);
//		}
//		else{
//			left.clear();
//			left.add(current);
//		}
//
//		int lastRightValue = right.get(right.size()-1);
//		if(current +1 == lastRightValue ){
//			right.add(current);
//		}
//		else{
//			right.clear();
//			right.add(current);
//		}
//
//		if(maxList.size()<left.size()){
//			maxList = new ArrayList<Integer>(left);
//		}
//		if(maxList.size()<right.size()){
//			maxList = new ArrayList<Integer>(right);
//		}
//		return left.size()>right.size()? left:right;
//	}
//
//	private boolean isLeaf(TreeNode root) {
//		if(root.left == null && root.right == null){
//			return true;
//		}
//		return false;
//	}
//
////    List<Integer> longestList(TreeNode root){
////
////
////    }
//
//}

