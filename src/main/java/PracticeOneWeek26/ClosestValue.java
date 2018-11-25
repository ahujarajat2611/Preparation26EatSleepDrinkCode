package PracticeOneWeek26;

/**
 * Created by hadoop on 8/12/17.
 */
public class ClosestValue {


    double closestValue(TreeNode node, double target){
        double diff = Integer.MAX_VALUE;
        int ans = 0;
        while (node!=null){
            if(node.val == target){
                return target;
            }
            if(Math.abs(node.val-target)<diff){
                diff = Math.abs(node.val-target);
                ans = node.val;
            }
            else if(target<node.val){
                node = node.left;
            }
            else if(target>node.val){
                node = node.right;
            }
        }
        return ans;
    }


    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
}
