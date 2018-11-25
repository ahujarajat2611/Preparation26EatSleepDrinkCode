package BasicAlgorithms.BinarySearch;
import java.util.*;

/**
 * Created by hadoop on 6/1/18.
 */
public class ConnectEasy {
    public void connect(TreeNode root) {
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode prev = null;
            TreeNode cur = null;
            for (int i = 0; i < size; i++){
                cur = queue.poll();
                if (prev != null){
                    prev.next = cur;
                }
                prev = cur;
                if (cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            cur.next = null;
        }
    }
    private class TreeNode{
        TreeNode left;
        TreeNode right;
        TreeNode next;
        int  val;
        TreeNode( int val){
            this.val = val;
        }
    }
    public void connectSuperEasy(TreeNode root) {
        if (root == null){
            return;
        }
        root.next = null;
        dfs(root);
    }
    public void dfs(TreeNode cur){
        if (cur.left != null && cur.right != null){
            cur.left.next = cur.right;

            // try both curr left next andd curr -right -next which will point to curr-next-left
            // in case of full tree
            // left ka easy hai rigth mein probelm hai ...
            if (cur.next != null){
                cur.right.next = cur.next.left;
            } else {
                cur.right.next = null;
            }


            dfs(cur.left);
            dfs(cur.right);
        }
    }
    public void connectSuperEasyFull(TreeNode root) {
        if (root == null){
            return;
        }
        root.next = null;
        dfsSuperEasy(root);
    }

    private void dfsSuperEasy(TreeNode cur){
        if (cur.right != null){
            cur.right.next = null;
            TreeNode temp = cur;
            while(temp.next != null){
                if (temp.next.left != null){
                    cur.right.next = temp.next.left;
                    break;
                } else if (temp.next.right != null){
                    cur.right.next = temp.next.right;
                    break;
                }
                temp = temp.next;
            }
            dfs(cur.right);
        }
        if (cur.left != null){
            if (cur.right != null){
                cur.left.next = cur.right;
            } else {
                cur.left.next = null;
                TreeNode temp = cur;
                while(temp.next != null){
                    if (temp.next.left != null){
                        cur.left.next = temp.next.left;
                        break;
                    } else if (temp.next.right != null){
                        cur.left.next = temp.next.right;
                        break;
                    }
                    temp = temp.next;
                }
            }
            dfs(cur.left);
        }
    }
}
