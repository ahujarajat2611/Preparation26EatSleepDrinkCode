package BasicAlgorithms.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 17/10/17.
 */
public class GetTreePath {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> path = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        path.add(String.valueOf(root.val));
        binaryTreePathsHelper(root,path,result);
        return result;
    }

    private void binaryTreePathsHelper(TreeNode root, List<String> path, List<String> result) {
        if(isLeaf(root)){
            String ans = "";
            for(int i=0;i<path.size()-1;i++) {
                ans =  ans+path.get(i)+"->";
            }
            ans = ans + path.get(path.size()-1);
            result.add(ans);
            return;
        }
        if(root.left!=null){
            path.add(String.valueOf(root.left.val));
            binaryTreePathsHelper(root.left,path,result);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            path.add(String.valueOf(root.right.val));
            binaryTreePathsHelper(root.right,path,result);
            path.remove(path.size()-1);
        }
    }

    private boolean isLeaf(TreeNode root) {
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
