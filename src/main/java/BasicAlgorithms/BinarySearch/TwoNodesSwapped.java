package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 7/1/18.
 */
public class TwoNodesSwapped {
    public class Solution {
        TreeNode firstElement;
        TreeNode secondElement;
        TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {
            inorder(root);
            int temp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = temp;
        }

        public void inorder(TreeNode cur) {
            if (cur == null) {
                return;
            }
            inorder(cur.left);
            // begin do something with cur node
            if (firstElement == null && prevElement.val >= cur.val) {
                firstElement = prevElement;
            }
            if (firstElement != null && prevElement.val >= cur.val) {
                secondElement = cur;
            }
            prevElement = cur;
            // end do something with cur node
            inorder(cur.right);

        }
    }
}
