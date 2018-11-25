package BasicAlgorithms.BinarySearch;

import java.util.ArrayList;
import java.util.*;
import java.util.Stack;

/**
 * Created by hadoop on 17/10/17.
 */
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (true){
            while (node!=null){
                stack.push(node);
                list.add(node.val);
                node = node.left;
            }
            TreeNode popped = stack.pop();
            if(stack.isEmpty()){
                break;
            }
            if(popped.right!=null){
                node = popped.right;
            }
        }
        return list;
    }

    public List<Integer> Inorder(TreeNode root) {
        return null;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode lastpost = null;
        TreeNode node = root;
        while(true)
        {
            while(node != null)
            {
                s.push(node);
                node = node.left;
            }

            if(s.isEmpty())break;
            TreeNode topagain= s.pop();

            if(topagain.right==null || topagain.right == lastpost){
                list.add(topagain.val);
                lastpost = topagain;
                node = null;
            }

            else {
                s.push(topagain);
                // s.push(topagain.right);
                node = topagain.right;
            }
        }
        return list;
    }
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}