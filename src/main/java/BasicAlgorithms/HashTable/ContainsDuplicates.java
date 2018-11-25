package BasicAlgorithms.HashTable;

/**
 * Created by hadoop on 23/10/17.
 */
import java.util.*;
public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        // 0 ..kth remove
        //1 k+1th remove .. 1 to k
        //
        for (int i = 0;i < nums.length; i++) {
            if (i >= k) set.remove(nums[i - k]);//Because the distance
            // between i and i - k - 1 is large than k,
            // so just let the nums[n-k-1] out
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    public boolean containsAlmostNearbyDuplicate(int[] nums, int k,int t) {

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0;i < nums.length; i++) {
            //Because the distance between i and i - k - 1 is large than k, so just let the nums[n-k-1] out
            Long floor = set.floor(((long)nums[i]+(long)t));
            Long ceil = set.ceiling(((long)nums[i]-(long)t));
            if(floor!=null  && floor >=(long)nums[i] || ceil!=null && ceil<=(long)nums[i] ) {
                return true;
            }
            set.add((long)nums[i]);
            if (i >= k) set.remove((long)nums[i - k]);
        }
        return false;
    }
    private TreeNode add(TreeNode root, TreeNode nNode) {
        if(root == null) {
            return nNode;
        }
        else if(root.val < nNode.val) {
            root.right = add(root.right, nNode);
            return root;
        }
        else {
            root.left = add(root.left, nNode);
            return root;
        }
    }

    private TreeNode delete(TreeNode root, TreeNode dNode) {
        if(root == null) {
            return null;
        }
        else if(root.val < dNode.val) {
            root.right = delete(root.right, dNode);
            return root;
        }
        else if(root.val > dNode.val) {
            root.left = delete(root.left, dNode);
            return root;
        }
        else if(root == dNode) {
            if(dNode.left == null && dNode.right == null) return null;
            else if(dNode.left != null && dNode.right == null) return dNode.left;
            else if(dNode.right != null && dNode.left == null) return dNode.right;
            else {
                TreeNode p = dNode.right;
                while(p.left != null) p = p.left;
                dNode.right = delete(dNode.right, p);
                p.left = dNode.left;
                p.right = dNode.right;
                return p;
            }
        }
        else {
            return root;
        }
    }

    private boolean search(TreeNode root, long val, int t) {
        if(root == null) {
            return false;
        }
        else if(Math.abs((root.val - val)) <= t) {
            return true;
        }
        else if((root.val - val) > t) {
            return search(root.left, val, t);
        }
        else {
            return search(root.right, val, t);
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0 || nums.length <= 1) {
            return false;
        }
        int len = nums.length;
        TreeNode[] map = new TreeNode[len];
        map[0] = new TreeNode((long)nums[0]);
        TreeNode root = null;
        root = add(root, map[0]);
        for(int i = 1; i < len; i++) {
            if(search(root, (long)nums[i], t)) {
                return true;
            }
            map[i] = new TreeNode((long)nums[i]);
            if(i - k >= 0) {
                root = delete(root, map[i-k]);
            }
            root = add(root, map[i]);
        }
        return false;
    }
    private class TreeNode{
        long val;
        TreeNode left;
        TreeNode right;
        public TreeNode(long x) {
            val = x;
        }
    }
    private class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

            TreeSet<Long> ts = new TreeSet<>();
            for (int i=0; i<nums.length; i++) {
                // -t <= x-nums[i] <= t
                if (ts.floor((long)nums[i]+(long)t) != null
                        && ts.floor((long)nums[i]+(long)t) >= (long)nums[i]-(long)t) {
                    return true;
                }
                ts.add((long)nums[i]);
                if (i >= k) {
                    ts.remove((long)nums[i-k]);
                }
            }
            return false;

        }
    }
}
