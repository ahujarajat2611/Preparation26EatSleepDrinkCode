package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 4/3/18.
 */
import java.util.*;
public class ClosestKValueMine {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        PriorityQueue<Double> maxDiffHeap = new PriorityQueue<Double>(new Comparator<Double>(){
            @Override
            public int compare(Double a, Double b){
                return (int)(Math.abs(b-target) - Math.abs(a-target));
            }
        });
        List<Integer> ans = new LinkedList<Integer>();
        helper(root,ans,maxDiffHeap,k);
        while(!maxDiffHeap.isEmpty()){
            ans.add((int)(maxDiffHeap.poll()).intValue());
        }
        return ans;
    }
    void helper(TreeNode root,List<Integer> ans, PriorityQueue<Double> maxDiffHeap ,int k){
        if(root == null){
            return ;
        }
        helper(root.left,ans,maxDiffHeap,k);
        if(maxDiffHeap.size() < k){
            maxDiffHeap.add((double)(root.val));
        }
        else{
            maxDiffHeap.add((double)(root.val));
            maxDiffHeap.poll();
        }
        helper(root.right,ans,maxDiffHeap,k);
    }
}
