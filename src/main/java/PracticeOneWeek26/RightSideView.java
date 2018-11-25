package PracticeOneWeek26;

import java.util.*;
/**
 * Created by hadoop on 7/12/17.
 */
public class RightSideView {
    public List<Integer> rightSideView( TreeNode root )
    {
        List<Integer> result = new LinkedList<>();
        HashSet<Integer> height = new HashSet<Integer>();
        rightViewRecurse( root, result, 0 ,height);
        return result;
    }

    private void rightViewRecurse( TreeNode root, List<Integer> result, int currDepth ,HashSet<Integer> hashset)
    {
        if ( root == null )
        {
            return;
        }
        if(!hashset.contains(currDepth)){
            result.add( root.val );
            hashset.add(currDepth);
        }

        rightViewRecurse( root.right, result, currDepth + 1 ,hashset);
        rightViewRecurse( root.left, result, currDepth + 1 ,hashset);
    }

    public List<Integer> rightSideViewAgain(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            size--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (size == 0) {
                rst.add(node.val);
                size = queue.size();
            }
        }

        return rst;
    }
}
