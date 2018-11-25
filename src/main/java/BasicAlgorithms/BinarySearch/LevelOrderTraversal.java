package BasicAlgorithms.BinarySearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadoop on 17/10/17.
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size  =queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode polled = queue.poll();
                list.add(polled.val);
                if(polled.left!=null){
                    queue.add(polled.left);
                }
                if(polled.right!=null){
                    queue.add(polled.right);
                }
            }
            result.add(list);
        }
        return result;
    }
    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val = x;
        }
    }
}
