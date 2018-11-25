package PracticeOneWeek26;

import javax.swing.tree.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 7/12/17.
 */
public class BinaryTreeConsecutive {
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(1);
        longestConsecutiveHelper(root,atomicInteger);
        return atomicInteger.get();
    }
    private class ResultType{
        int length;
        int lastvalue;
        ResultType(int length,int lastvalue){
            this.length = length;
            this.lastvalue = lastvalue;
        }
    }

    private ResultType longestConsecutiveHelper(TreeNode node,AtomicInteger atomicInteger) {
        if(node == null){
            return new ResultType(0,Integer.MIN_VALUE);
        }
        if(node.left == null && node.right ==null){
            return new ResultType(1,node.val);
        }

        ResultType leftLongest = longestConsecutiveHelper(node.left,atomicInteger);
        ResultType rightLongest = longestConsecutiveHelper(node.right,atomicInteger);

        int currentval = node.val;
        int currentmaxlength = 1;
        int leftlongest =0;
        int rightlongest = 0;

        if(currentval +1 == leftLongest.lastvalue){
            leftlongest = leftLongest.length;
        }
        if(currentval +1 == rightLongest.lastvalue){
            rightlongest = rightLongest.length;
        }
        currentmaxlength = Math.max(leftlongest,rightlongest)+1;
        if(currentmaxlength>atomicInteger.get()){
            atomicInteger.set(currentmaxlength);
        }
        return new ResultType(currentmaxlength,currentval);
    }
    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }

}
