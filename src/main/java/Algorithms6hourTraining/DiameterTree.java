package Algorithms6hourTraining;

import smallmomentsmakeitbigger26.TreeNode;

/**
 * Created by hadoop on 21/12/17.
 */


/*
keep track of max of left ,right+1
and return max of (left,right)
 */
public class DiameterTree {
    public int diameterOfBinaryTree2(TreeNode root) {
        if(root == null){
            return 0;
        }
        /// this is not optimized soltuion
        int dia = 1 + depth(root.left) + depth(root.right);
        int leftDia = diameterOfBinaryTree2(root.left);
        int rightDia = diameterOfBinaryTree2(root.right);

        return Math.max(dia,Math.max(leftDia,rightDia));

    }
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    /**
     * Created by hadoop on 24/10/17.
     */
    class Diameter {
        public int diameterOfBinaryTree(TreeNode root) {
            ResultType ans = dfsHelper(root);
            return ans.diameter;
        }

        private ResultType dfsHelper(TreeNode root) {
            if(root == null){
                // first denotes the localcurrent height
                // second denotes the max value overall !!
                return new ResultType(0,Integer.MIN_VALUE);
            }
            if(root.left == null && root.right == null){
                return new ResultType(1,1);
            }
            ResultType left = dfsHelper(root.left);
            ResultType right = dfsHelper(root.right);

            int localheight = Math.max(left.height,right.height)+1;
            // max just keep track of ans final ans
            int diameter = Math.max(Math.max(left.diameter,right.diameter),left.height + right.height +1);
            ResultType resultType = new ResultType(localheight,diameter);
            return resultType;
        }

        private class ResultType{
            int height;
            int diameter;

            public ResultType(int height, int diameter) {
                this.height = height;
                this.diameter = diameter;
            }
        }
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
    }

}
