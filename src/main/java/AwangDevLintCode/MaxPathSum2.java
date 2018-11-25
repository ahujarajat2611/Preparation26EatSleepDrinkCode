package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
public class MaxPathSum2 {
    /*

    WRONG
    WROOOONGGG
    THIS CODE WILL WORK IF WE WANT MAX PATH FROM ROOT TO TREEE
    BUT QUESTION IS SOMETHING ELSE PATH CAN END ON ANY ROOT
    APPROACH IS DIVIDE AND CONQUER
     */
//    public int maxPathSum2(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return helper(root,root.val);
//    }

//    public int helper(TreeNode node,int sum) {
//        if (node == null) {
//            return 0;
//        } else if (node.left == null && node.right == null) {
//            return sum;
//        }
//        int ans =0;
//        if(node.left!=null){
//            ans = Math.max(ans,helper(node.left,sum + node.left.val));
//        }
//        if(node.right!=null){
//            ans = Math.max(ans,helper(node.right,sum + node.right.val));
//        }
//
//        return ans;
//    }
    public int maxPathSum2SimpleAndCorrect(TreeNode root) {
        // Write your code here
        if(root == null){
            return 0;
        }

        int left = maxPathSum2SimpleAndCorrect(root.left);
        int right = maxPathSum2SimpleAndCorrect(root.right);

        return root.val + Math.max(0, Math.max(left, right));
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(-3);
        node.right = new TreeNode(-44);
            MaxPathSum2 maxPathSum2 = new MaxPathSum2();
        System.out.println(maxPathSum2.maxPathSum2SimpleAndCorrect(node));
        System.out.println(maxPathSum2.maxPathSum2SimpleAndCorrect(node));
    }
}

