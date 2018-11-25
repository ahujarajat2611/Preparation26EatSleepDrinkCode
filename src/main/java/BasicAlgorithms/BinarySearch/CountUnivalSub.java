package BasicAlgorithms.BinarySearch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 17/10/17.
 */
public class CountUnivalSub {
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
                // Very thouthfulll
                integer.set(integer.get()+1);
                return new ResultType(node.val,true);
            }
            else {
            // very thoughtfullll done here
                if(node.val == left.val && Integer.MIN_VALUE == right.val){
                    integer.set(integer.get()+1);
                    return new ResultType(node.val,true);
                }
        // very thoughtfull done here
                if(node.val == right.val && Integer.MIN_VALUE == left.val){
                    integer.set(integer.get()+1);
                    return new ResultType(node.val,true);
                }
            }
            return new ResultType(Integer.MAX_VALUE,false);
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