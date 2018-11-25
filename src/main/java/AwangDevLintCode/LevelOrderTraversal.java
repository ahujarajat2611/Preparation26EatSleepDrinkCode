package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
import java.util.*;
public class LevelOrderTraversal {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(0, list);
        }// end while

        return result;
    }

}
