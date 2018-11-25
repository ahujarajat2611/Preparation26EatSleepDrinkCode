package BasicAlgorithms.Dfs;

/**
 * Created by hadoop on 24/10/17.
 */
import java.util.*;
public class TreeDfsTemplate {
    private class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            traverse(root, res, 0);
            return res;
        }

        private void traverse(TreeNode root, List<List<Integer>> res, int level) {
            if (root == null) return;
            if (res.size() - 1 < level) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            level++;
            traverse(root.left, res, level);
            traverse(root.right, res, level);
        }
    }
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    private class SolutionA {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root!=null)
                findLeaves(res, root);
            return res;
        }

        private int findLeaves(List<List<Integer>> res, TreeNode root) {
            int left = -1;
            int right = -1;
            if(root.left != null) {
                left = findLeaves(res, root.left);
            }
            if(root.right != null) {
                right = findLeaves(res, root.right);
            }
            int depth = Math.max(left, right) + 1;
            if(res.size() < depth + 1) {
                res.add(new ArrayList<>());
            }
            res.get(depth).add(root.val);
            return depth;
        }
        private int findLeavesMine(List<List<Integer>> res ,TreeNode node){
            if(node == null){
                return 0;
            }

            int leftHeight = findLeavesMine(res,node.left);
            int rightHeight = findLeavesMine(res,node.right);

            int currentHeight = Math.max(leftHeight,rightHeight)+1;
            if(res.size() < currentHeight){
                res.add(new ArrayList<>());
            }
            res.get(currentHeight-1).add(node.val);
            return currentHeight;
        }
    }
    public List<Integer> maxInEachLevel(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfsintree(root, res, 1);
        for(List<Integer> it:res){
            ans.add(Collections.max(it));
        }
        return ans;
    }

    private void dfsintree(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null){
            return;
        }
        if(res.size() -1 <level){
            res.add(new ArrayList<>());
        }
        res.get(level-1).add(root.val);
        dfsintree(root.left,res,level+1);
        dfsintree(root.right,res,level+1);
    }
}
