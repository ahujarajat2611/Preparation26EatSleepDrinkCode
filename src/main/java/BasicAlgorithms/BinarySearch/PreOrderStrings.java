package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class PreOrderStrings {
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }
        if(t.left == null && t.right == null){
            return ""+t.val;
        }
        String result="";
        if(t.left!=null && t.right!=null){
            return result = result  +"("+tree2str(t.left)+")" +"("+tree2str(t.right)+")";
        }
        else if(t.left == null && t.right!=null){
            return result = result  +"("+tree2str(t.left)+")" +"("+tree2str(t.right)+")";
        }
        else {
            return result = result  +"("+tree2str(t.left)+")";
        }
    }
    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
}
