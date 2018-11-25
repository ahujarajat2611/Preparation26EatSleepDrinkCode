package smallmomentsmakeitbigger26;
import java.util.*;
/**
 * Created by hadoop on 14/12/17.
 */
public class  UniqueBsts {
    public List<TreeNode> generateTrees(int n) {
        if(n ==0){
            return new ArrayList<>();
        }
        return dfs(0,n-1);
    }

    private List<TreeNode> dfs(int start, int end) {
        // there are case where
        // you have deal with returnin some sort of list . stack
        // that case you need to be caeful to add recustion list,stack
        // to final stack
        ArrayList<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        for(int middle = start;middle<=end;middle++){
            List<TreeNode> left = dfs(start,middle-1);
            List<TreeNode> right = dfs(middle+1,end);

            // cartesian prodcutr
            for(TreeNode left1: left){
                for(TreeNode right1 :right){
                    TreeNode treeNode = new TreeNode(middle);
                    treeNode.left = left1;
                    treeNode.right = right1;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }
    /*
    public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int m, int n){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (m > n){
            res.add(null);
            return res;
        }

        for (int i = m; i <= n; i++){

            List<TreeNode> left = dfs(m, i - 1);
            List<TreeNode> right = dfs(i + 1, n);

            for (TreeNode node1: left){
                for (TreeNode node2: right){
                    TreeNode root = new TreeNode(i);
                    root.left = node1;
                    root.right = node2;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
     */
}