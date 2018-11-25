package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 7/12/17.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        sum = sum -root.val;
        return hasPathSumHelper(root,sum);

    }
    public boolean hasPathSumHelper(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right ==null && sum == 0){
            return true;
        }
        boolean leftans = false;
        if(root.left!=null){
            /// case of Backktracking simpleee it is
            // at child level thinsg are being done
            // check if child is valie
            // if yes then reduce and pass it to further recursion
            // deleted value
            //. how everwe need to take care of recursion as well
            sum = sum-root.left.val ;
            System.out.println("left"+sum);
            leftans = hasPathSumHelper(root.left,sum);
            sum = sum + root.left.val;

        }
        boolean rightans = false;
        if(root.right!=null){
            sum = sum-root.right.val ;
            System.out.println("right"+sum);

            rightans = hasPathSumHelper(root.right,sum);
            sum = sum + root.right.val;

        }
        return leftans || rightans;
        // usuaing flow is
        // if for ()
                // child vlaie
                // if(recr)
                //        return true
                // bracktrack



    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if (root == null) {
            return rst;
        }
        helper(root, rst, new ArrayList<Integer>());
        return rst;
    }

    public void helper(TreeNode root, List<String> rst, ArrayList<Integer> list){
        list.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i) + "->");
            }
            sb.append(list.get(list.size() - 1));
            rst.add(sb.toString());
        }
        if (root.left != null) {
            helper(root.left, rst, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            helper(root.right, rst, list);
            list.remove(list.size() - 1);
        }
    }
}
