package DSA.trees.binary;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 22/2/18.
 */
public class CountUniValueSubtrees {
    private class ResultType{
        int val;
        boolean isunisubtree;

        public ResultType(int val, boolean isunisubtree) {
            this.val = val;
            this.isunisubtree = isunisubtree;
        }
    }
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        AtomicInteger integer = new AtomicInteger();
        countUnivalSubtreesHelper(root,integer);
        return integer.get();
    }

    ResultType countUnivalSubtreesHelper(TreeNode node,AtomicInteger integer){
        if(node == null){
            return new ResultType(Integer.MIN_VALUE,true);
        }
        if(node.left == null && node.right == null){
            integer.set(integer.get()+1);
            return new ResultType(node.val,true);
        }
        else {
            ResultType left = countUnivalSubtreesHelper(node.left,integer);
            ResultType right = countUnivalSubtreesHelper(node.right,integer);

            if(left.isunisubtree == false || right.isunisubtree == false){
                return new ResultType(Integer.MIN_VALUE,false);
            }


            if(node.val == left.val && node.val == right.val){
                integer.set(integer.get()+1);
                return new ResultType(node.val,true);
            }
            else {

                if(node.val == left.val && Integer.MIN_VALUE == right.val){
                    integer.set(integer.get()+1);
                    return new ResultType(node.val,true);
                }

                if(node.val == right.val && Integer.MIN_VALUE == left.val){
                    integer.set(integer.get()+1);
                    return new ResultType(node.val,true);
                }
            }
            return new ResultType(Integer.MAX_VALUE,false);
        }
    }
}
/*
    public int countUnivalSubtrees(TreeNode root) {
     int[] result = determine(root);

     return result[0];
    }

    public int[] determine(TreeNode root){

      if(root == null){
        return new int[]{0,1};
      }

      if(root.left == null && root.right == null){
          return new int[]{1,1};
      }

      int[] left = determine(root.left);
      int[] right = determine(root.right);
      int[] result = new int[2];

      if(left[1] == 1 && right[1] == 1 &&(root.left== null || root.left.val == root.val) && (root.right == null || root.right.val ==         root.val)){
         result [0] = left[0] + right[0] + 1;
         result[1] = 1;
      }
      else{
          result[0] = left[0] + right[0];
          result[1] = 0;
      }

     return result;

    }

 */
