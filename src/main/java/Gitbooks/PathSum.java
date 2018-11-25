package Gitbooks;

import java.util.List;

/**
 * Created by hadoop on 13/9/17.
 */
public class PathSum {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public boolean hasPathSum(TreeNode root,int sum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right ==null && sum == 0){
            return true;
        }
        sum = sum-root.val ;
        boolean leftans = hasPathSum(root.left,sum);
        boolean rightans = hasPathSum(root.right,sum);
        sum = sum + root.val;
        return leftans || rightans;
    }
    public boolean hasPathSumPath(TreeNode root, int sum, List<Integer>path, List<List<Integer>> result){
        if(root == null){
            return false;
        }
        sum = sum-root.val ;
        path.add(root.val);
        if(root.left == null && root.right ==null && sum == 0){
            return true;
        }
        boolean leftans = hasPathSum(root.left,sum);
        boolean rightans = hasPathSum(root.right,sum);
        sum = sum + root.val;
        path.remove(path.size()-1);
        return leftans || rightans;
    }
    public int countPath(TreeNode root,int sum){

        if(root == null)
            return 0;
        return pathFromRoot(root,sum) +countPath(root.left,sum)+countPath(root.right,sum);

    }
    int pathFromRoot(TreeNode root,int sum){
        if(root == null) return 0;
        sum = sum -root.val;
        int count = 0;
        if(root.left == null && root.right == null && sum ==0){
            count++;
        }
        count += pathFromRoot(root.left,sum);
        count += pathFromRoot(root.right,sum);
        return count;
    }
}
