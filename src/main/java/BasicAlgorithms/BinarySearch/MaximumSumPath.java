package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 3/9/17.
 */
public class MaximumSumPath {
    public static void main(String[] args) {

    }

    ResultType MaxPathSum(TreeNode root){
        if(root == null){
            return new ResultType(0,Integer.MIN_VALUE);
        }
        ResultType left = MaxPathSum(root.left);
        ResultType right = MaxPathSum(root.right);

        int singlePath= Math.max(left.singlePath,right.singlePath)+root.data;
        if(singlePath<0){
            singlePath = 0;
        }
        int maxpath = Math.max(left.maxPath,right.maxPath);
        maxpath = Math.max(maxpath,left.singlePath+right.singlePath+root.data);
        return new ResultType(singlePath,maxpath);
    }

    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }
    private class ResultType{
        int singlePath;
        int maxPath;

        public ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
}
