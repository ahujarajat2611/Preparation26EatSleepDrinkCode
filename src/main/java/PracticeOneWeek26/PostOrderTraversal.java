package PracticeOneWeek26;

import java.util.*;
/**
 * Created by hadoop on 7/12/17.
 */
public class PostOrderTraversal {
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
                node = topagain.right;
            }
        }
        return list;
    }
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
            if(stack.isEmpty()){
                break;
            }
            TreeNode popped = stack.pop();

            if(popped.right!=null){
                node = popped.right;
            }
        }
        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (true){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode popped = stack.pop();
            list.add(popped.val);
            if(popped.right!=null){
                node = popped.right;
            }
        }
        return list;
    }
}
