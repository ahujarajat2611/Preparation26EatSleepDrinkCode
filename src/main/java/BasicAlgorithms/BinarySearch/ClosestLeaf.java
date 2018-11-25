package BasicAlgorithms.BinarySearch;

import smallmomentsmakeitbigger26.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 24/12/17.
 */
public class ClosestLeaf{
        public int findClosestLeaf(TreeNode root, int k) {
            if(root == null) {
                return Integer.MAX_VALUE;
            }
            AtomicInteger integer = new AtomicInteger();
            integer.set(Integer.MAX_VALUE);
            helper(root,k,integer);
            return integer.intValue();
        }

        private void helper(TreeNode root, int k, AtomicInteger integer) {
            if(root == null) {
                return;
            }
            if(isLeaf(root)) {
                if (Math.abs(k - integer.get()) > Math.abs(k - root.val)) {
                    integer.set(root.val);
                }
            }
            helper(root.left,k,integer);
            helper(root.right,k,integer);
        }

        private boolean isLeaf(TreeNode root) {
            if(root.left == null && root.right == null) {
                return true;
            }
            return false;
        }
    public int findClosestLeafCorrect(TreeNode root, int k) {
            Map<TreeNode,TreeNode> backEdge = new HashMap<>();
            TreeNode startPoint = dfs(root,k,backEdge);
            if(startPoint == null){
                return Integer.MAX_VALUE;
            }
            return bfs(startPoint,backEdge);
    }

    private int bfs(TreeNode startPoint, Map<TreeNode, TreeNode> backEdge) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(startPoint);
        visited.add(startPoint);

        while (!queue.isEmpty()){
            TreeNode polled = queue.poll();
            if(polled.left!=null && !visited.contains(polled.left)){
                queue.add(polled.left);
                visited.add(polled.left);
            }
            if(polled.right!=null && !visited.contains(polled.right)){
                queue.add(polled.right);
                visited.add(polled);
            }
            if(polled.left == null && polled.right == null){
                return polled.val;
            }

            if(backEdge.get(polled)!=null && !visited.contains(backEdge.get(polled))){
                visited.add(backEdge.get(polled));
                queue.add(backEdge.get(polled));
            }
        }
        return Integer.MAX_VALUE;
    }

    private TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> backEdge) {
            if(root == null){
                return null;
            }
            if(root.val == k){
                return root;
            }
            if(root.left !=null) {
                backEdge.put(root.left,root);
                TreeNode left = dfs(root.left, k, backEdge);
                if(left !=null){
                    return left;
                }
            }
            if(root.right != null){
                backEdge.put(root.right,root);
                TreeNode right = dfs(root.right,k,backEdge);
                if(right!=null){
                    return right;
                }
            }
            return null;

        }
}
