package BasicAlgorithms.kth;

public class Solution {
    // it is impossible for root to be null here
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k == count + 1){
            return root.val;
        } else if (k < count + 1){
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - count - 1);
        }
    }
    
    public int countNodes(TreeNode cur){
        if (cur == null){
            return 0;
        }
        return 1 + countNodes(cur.left) + countNodes(cur.right);
    }
}

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }