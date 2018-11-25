package PracticeOneWeek26;

/**
 * Created by hadoop on 7/12/17.
 */
public class MaxPathSum2Lintcode {
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null){
            return 0;
        }

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        return root.val + Math.max(0, Math.max(left, right));
    }
    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
    public int maxPathSum (TreeNode node){
        if(node == null){
            return 0;
        }
        ResultType resultType = maxPathHelper(node);
        return Math.max(resultType.maxpath,resultType.currentPath);
    }

    private ResultType maxPathHelper(TreeNode node) {
        if(node == null){
            return new ResultType(Integer.MIN_VALUE,Integer.MIN_VALUE);
        }
        if(node.right == null && node.left == null){
            return new ResultType(node.val,node.val);
        }

        ResultType left = maxPathHelper(node.left);
        ResultType right = maxPathHelper(node.right);

        int currentPath = Math.max(node.val,Math.max(left.currentPath,right.currentPath) +node.val);
        int maxpath = Math.max(currentPath,Math.max(left.maxpath,Math.max(right.maxpath,node.val+

                (right.currentPath!= Integer.MIN_VALUE ?right.currentPath:0) +
                (left.currentPath!= Integer.MIN_VALUE ?left.currentPath:0))));


        return new ResultType(currentPath,maxpath);
    }
    private class ResultType{
        int currentPath;
        int maxpath;
        ResultType(int currentPath,int maxpath){
            this.maxpath = maxpath;
            this.currentPath = currentPath;
        }

        @Override
        public String toString() {
            return "ResultType{" +
                    "currentPath=" + currentPath +
                    ", maxpath=" + maxpath +
                    '}';
        }
        ResultType(){

        }
    }

}
