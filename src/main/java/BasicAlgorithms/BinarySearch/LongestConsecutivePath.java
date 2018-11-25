package BasicAlgorithms.BinarySearch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 17/10/17.
 */
public class LongestConsecutivePath {
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
        //   System.out.println("left value"+leftLongest.lastvalue);
        //  System.out.println("left longest"+leftLongest.length);

        //    System.out.println("right value"+rightLongest.lastvalue);
        //   System.out.println("right longest"+rightLongest.length);

        if(currentval +1 == leftLongest.lastvalue){
            leftlongest = leftLongest.length;
        }
        if(currentval +1 == rightLongest.lastvalue){
            rightlongest = rightLongest.length;
        }
        // addding seprete 1 sinnce we want to return incase above if
        // cases are not true .. like startting again from 1
        // here tracking max item seprately not in result type
        // we could have one ore variable in reulttypeiselt
        currentmaxlength = Math.max(leftlongest,rightlongest)+1;
        if(currentmaxlength>atomicInteger.get()){
            atomicInteger.set(currentmaxlength);
        }
        return new ResultType(currentmaxlength,currentval);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}