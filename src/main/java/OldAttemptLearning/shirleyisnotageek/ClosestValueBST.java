package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 18/1/18.
 */
public class ClosestValueBST {
    public class Solution {
        int goal;
        double min = Double.MAX_VALUE;

        public int closestValue(TreeNode root, double target) {
            helper(root, target);
            return goal;
        }

        public void helper(TreeNode root, double target){
            if(root==null)
                return;

            if(Math.abs(root.val - target) < min){
                min = Math.abs(root.val-target);
                goal = root.val;
            }

            if(target < root.val){
                helper(root.left, target);
            }else{
                helper(root.right, target);
            }
        }
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                // priority queue Max Queue ( ) ;
                // Max queue :- ( );
                // Sort things based on the diff value ..
                // so having a priority queue based out of difference
                // so difference needs to

                // in short
               // return Math.abs(o2-target) - Math.abs(o1-target);
                double difference = Math.abs(o1.doubleValue() - target) - Math.abs(o2.doubleValue() - target);
                if (difference > 0) {
                    return -1;
                } else if (difference < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        getKValues(root, target, k, queue);
        while (!queue.isEmpty()) {
            rst.add(queue.poll());
        }
        return rst;
    }

    private void getKValues(TreeNode root, double target, int k, PriorityQueue<Integer> queue) {
        if (root == null) {
            return;
        }
        getKValues(root.left, target, k, queue);
        // WATT A NEAR PERFECT SOLUTION IT IS !!!!
        // REALLY NINCIE
        // PUSH INTO QUEUEU
        // IF SIZE IS MORE THAN K RMEOVE

        queue.add(root.val);
        if (queue.size() > k) {
            queue.poll();
        }
        getKValues(root.right, target, k, queue);
    }
    /*
    Using a priority queue. Recursively do an in order traversal and put nodes in the queue. If the size of the queue exceeds k, pull out the node with the largest difference.
     */
}
