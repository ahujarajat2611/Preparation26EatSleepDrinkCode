package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 16/1/18.
 */
public class LargestBST {

    // This solution seems wrong we need to compare with left max and right min which i am not doing it !!!!
    public int largestBSTSubtree(TreeNode root) {
        return getTree(root).max;
    }

    private BSTCounter getTree(TreeNode root) {
        if (root == null) {
            return new BSTCounter(0, 0);
        }
        if (root.left == null && root.right == null) {
            return new BSTCounter(1, 1);
        }
        BSTCounter left = getTree(root.left);
        BSTCounter right = getTree(root.right);
        BSTCounter curr = new BSTCounter(0, 0);
        if (left.curr == -1 || right.curr == -1
                || (root.left != null && root.left.val >= root.val)
                || (root.right != null && root.right.val <= root.val)) {
            curr.curr = -1;
            curr.max = Math.max(left.max, right.max);
        } else {
            curr.curr = left.curr + right.curr + 1;
            curr.max = curr.curr;
        }
        return curr;
    }

    private class BSTCounter {
        int curr;
        int max;
        public BSTCounter(int curr, int max){
            this.curr = curr;
            this.max = max;
        }
    }
}
