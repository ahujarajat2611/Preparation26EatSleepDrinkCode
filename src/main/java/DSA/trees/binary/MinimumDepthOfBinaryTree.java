package DSA.trees.binary;


import DSA.nodes.BinaryTreeNode;

/**
 * @author Raj
 * 
 *         Given a binary tree, find its minimum depth.
 * 
 *         The minimum depth is the number of nodes along the shortest path from
 *         the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(BinaryTreeNode<Integer> root) {
        if(null == root) return 0;
        int res[] = new int[1];
        res[0] = Integer.MAX_VALUE;
        minDepth(root,0,res);
        return res[0];
    }
    
    public void minDepth(BinaryTreeNode<Integer>  root,int level,int res[]){
        if(null == root) return;
        if(root.left==null && root.right==null){
            res[0]= Math.min(res[0],level+1);
        }
        minDepth(root.left,level+1,res);
        minDepth(root.right,level+1,res);
    }
	public int minDepthMine(TreeNode root) {
		if(root == null){
			return 0;
		}
		return minDepthHelperMine(root);
	}
	public int minDepthHelperMine(TreeNode node) {
		if(node == null){
			return Integer.MAX_VALUE;
		}
		if(node.left == null &&  node.right == null){
			return 1;
		}
		int lefheight = minDepthHelperMine(node.left);
		int rigthheight = minDepthHelperMine(node.right);

		int result = 1;
		result = result  + Math.min(lefheight,rigthheight);
		return result;

	}
    
    // Time : O(n)
	// https://discuss.leetcode.com/topic/8723/my-4-line-java-solution
	public int minDepth2(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		int left = minDepth2(root.left);
		int right = minDepth2(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : 1 + Math.min(left,right);
	}

	public static void main(String args[]) {
		MinimumDepthOfBinaryTree obj = new MinimumDepthOfBinaryTree();
		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);

		int res = -1;
		res = obj.minDepth(ob.root);
		System.out.println(res);
	}
}