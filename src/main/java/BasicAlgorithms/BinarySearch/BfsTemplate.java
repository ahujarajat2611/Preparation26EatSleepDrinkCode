package BasicAlgorithms.BinarySearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 4/9/17.
 */
public class BfsTemplate {


    public static void main(String[] args) {

    }
    ArrayList<ArrayList<Integer>>levelOrderTraversalTemplate(TreeNode root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if( root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode head = queue.poll();
                level.add(head.data);
                if(head.left!=null){
                    queue.add(head.left);
                }
                if(head.right!=null){
                    queue.add(head.right);
                }
            }
            result.add(new ArrayList<>(level));
        }
        return result;
    }
    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
