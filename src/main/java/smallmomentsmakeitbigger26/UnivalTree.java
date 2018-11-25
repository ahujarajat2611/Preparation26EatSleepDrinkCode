package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class UnivalTree {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }


    // same value tree we need to cout
    // there are easy way to deal with this problem
    // this is one of the way to deal
    // return boolean
    // both true and then compare left and right node if its is true
    // then addd to ans
    // we are going post ordder travesal
    // previously i have done
    // question of max uni value subtree here we need to count ..
    // so if left and right sub trees are uni values then add to your count .. quite straight forward ..
    // approach get answwers from the bottom !!!
    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
