package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 7/12/17.
 */
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }
    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        //Use a queue to list elements: each row
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = queue.size();//Limit the size, since the queue is increasing
            for (int i = 0; i < size; i++) {
                TreeNode levelNode = queue.poll();
                list.add(levelNode.val);//Add all the values from this current level
                if (levelNode.left != null) {
                    queue.offer(levelNode.left);
                }
                if (levelNode.right != null) {
                    queue.offer(levelNode.right);
                }
            }
            result.add(list);
        }//while

        return result;
    }
}
