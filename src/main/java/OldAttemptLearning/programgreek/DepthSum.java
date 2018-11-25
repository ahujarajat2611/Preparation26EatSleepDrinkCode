package OldAttemptLearning.programgreek;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

/**
 * Created by hadoop on 22/8/17.
 */
public class DepthSum {
    public static void main(String args[]){

    }
    public int depthSum(List<NestedInteger> nestedIntegerList){
        return helper(nestedIntegerList,1);
    }

    private int helper(List<NestedInteger> nestedIntegerList, int depth) {
        if(nestedIntegerList == null ||nestedIntegerList.size() == 0){
            return 0;
        }
        int sum=0;
        for(NestedInteger nestedInteger:nestedIntegerList){
            if(nestedInteger.isInteger()){
                sum = sum+ nestedInteger.getInteger()*depth;
            }
            else{
                sum = sum + helper(nestedIntegerList,depth+1);
            }
        }
        return sum;
    }
    public int depthSumIterative(List<NestedInteger> nestedIntegerList){
        int sum = 0;
        LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
        LinkedList<Integer> depth = new LinkedList<Integer>();
        for(NestedInteger nestedInteger:nestedIntegerList){
            queue.offer(nestedInteger);
            depth.offer(1);
        }
        while (!queue.isEmpty()){

            NestedInteger nestedInteger = queue.poll();
            int d = depth.poll();
            if(nestedInteger.isInteger()){
                sum = sum + nestedInteger.getInteger()*d;
            }
            else{
                for(NestedInteger nestedInteger1 :nestedInteger.getList()){
                    queue.offer(nestedInteger1);
                    depth.offer(d+1);
                }
            }
        }
        return sum;
    }
    public int function(List<NestedInteger> nestedIntegerList){
        Queue<Pair> entryQueue = new LinkedList<>();

        for(NestedInteger nestedInteger :nestedIntegerList){
            entryQueue.add(new Pair(nestedInteger,1));
        }
        int sum =0;
        while (!entryQueue.isEmpty()){
            Pair pair = entryQueue.poll();
            if(pair.nestedInteger.isInteger()){
                sum = sum+ pair.nestedInteger.getInteger()*pair.depth;
            }
            else {
                for(NestedInteger nestedInteger:pair.nestedInteger.getList()) {
                    entryQueue.add(new Pair(nestedInteger,pair.depth+1));
                }
            }
        }
        return sum;
    }
    public class Pair{
        NestedInteger nestedInteger;
        Integer depth;
        Pair(NestedInteger nestedInteger,Integer depth){
            this.nestedInteger = nestedInteger;
            this.depth = depth;
        }
    }
}
