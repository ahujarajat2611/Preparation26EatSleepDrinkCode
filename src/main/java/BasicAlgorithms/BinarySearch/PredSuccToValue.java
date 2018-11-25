package BasicAlgorithms.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hadoop on 18/10/17.
 */
public class PredSuccToValue {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> pred = new Stack<>();
        Stack<Integer> succ = new Stack<>();
        getpredeccsors(root,target, pred);
        getsuccessor(root,target,succ);
        List<Integer> list = new ArrayList<>();
        while (k-->0){
            if(succ.isEmpty()){
                list.add(pred.pop());
            }
            else if(pred.isEmpty()){
                list.add(succ.pop());
            }
            else if(Math.abs(succ.peek()-target)>Math.abs(pred.peek()-target)){
                list.add(pred.pop());
            }
            else {
                list.add(succ.pop());
            }
        }
        return list;

    }

    private void getpredeccsors(TreeNode root, double target, Stack<Integer> pred) {
        if (root == null){
            return;
        }
        getpredeccsors(root.left,target,pred);
        // it should be otherssiiw wrommg here
        if(root.val<target){
            return;
        }
        pred.push(root.val);
        getpredeccsors(root.right,target,pred);
    }
    private void getsuccessor(TreeNode root, double target, Stack<Integer> succ) {
        if (root == null){
            return;
        }
        getpredeccsors(root.right,target,succ);
        // it should be otherwise wrriing her e
        if(root.val>target){
            return;
        }
        succ.push(root.val);
        getpredeccsors(root.left,target,succ);
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}