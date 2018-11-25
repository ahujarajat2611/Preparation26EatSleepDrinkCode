package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 7/12/17.
 */
public class ZigZag {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return rst;
        }

        int level = 0;
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            size = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0 ; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
            rst.add(list);
        }

        return rst;

    }
}
