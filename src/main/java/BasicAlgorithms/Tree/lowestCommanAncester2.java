package BasicAlgorithms.Tree;

//Given a binary tree, find the lowest common ancestor of two given nodes in the tree.
//Each node contains a parent pointer which links to its parent.
class TreeNode{
    TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode() {
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}
public class lowestCommanAncester2 {
	public TreeNode findAncester(TreeNode n1, TreeNode n2) {
		int height1 = findHeight(n1);
		int height2 = findHeight(n2);
		int dis = Math.abs(height1 - height2);
		TreeNode lowerNode = height1 <= height2 ? n1 : n2;
		TreeNode higherNode = n1 == lowerNode ? n2 : n1;
		while (dis != 0) {
			lowerNode = lowerNode.parent;
			dis--;
		}
		while (lowerNode != higherNode) {
			lowerNode = lowerNode.parent;
			higherNode = higherNode.parent;
		}
		return lowerNode;
	}
	
	public int findHeight(TreeNode n) {
		int height = 0;
		while(n != null) {
			n = n.parent;
			height++;
		}
		return height;
	}
}
