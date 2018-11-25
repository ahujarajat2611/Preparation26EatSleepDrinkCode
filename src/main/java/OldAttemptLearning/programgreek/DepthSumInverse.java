package OldAttemptLearning.programgreek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadoop on 22/8/17.
 */
public class DepthSumInverse {
    public static void main(String[] args) {
        DepthSumInverse depthSumInverse = new DepthSumInverse();
        List<NestedInteger> list = new LinkedList<NestedInteger>();
        int ans = depthSumInverse.depthsum(list);
    }

    private int depthsum(List<NestedInteger> list) {
        if(list == null || list.size() ==0 ){
            return 0;
        }
        HashMap<Integer,ArrayList<Integer>> map= new HashMap<Integer,ArrayList<Integer>>();
        LinkedList<NestedInteger> queue  = new LinkedList<NestedInteger>();
        LinkedList<Integer> depth = new LinkedList<Integer>();
        for(NestedInteger nestedInteger: list){
            queue.offer(nestedInteger);
            depth.offer(1);
        }
        int maxheight = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            NestedInteger nestedInteger = queue.poll();
            int d = depth.poll();
            maxheight = Math.max(maxheight,d);
            if(nestedInteger.isInteger()){
                int x = nestedInteger.getInteger();
                if(map.containsKey(d)){
                    map.get(d).add(x);
                }
                else{
                    ArrayList<Integer> arraylist = new ArrayList<Integer>();
                    arraylist.add(x);
                    map.put(d,arraylist);
                }
            }
            else{
                for(NestedInteger nestedInteger1:nestedInteger.getList()){
                        queue.offer(nestedInteger1);
                        depth.offer(d+1);
                }
            }
        }
        int result =0;
        for(int i=maxheight;i>=1;i--){
            if(map.get(i)!=null) {
                for (Integer x :map.get(i)){
                    result = result+ (maxheight-i +1) * x;
                }
            }
        }
        return result;
    }
}
