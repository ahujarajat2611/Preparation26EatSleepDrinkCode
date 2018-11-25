package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 20/9/17.
 */
public class SubarraySumClosestToZero {
    List<Integer> subarrayCloses(int nums[]){
        List<Integer> list = new ArrayList<>();
        Pair [] pairs = new Pair[nums.length+1];
        pairs[0] = new Pair(0,-1);
        int currsum = 0;
        int mindiff= Integer.MAX_VALUE;
        int minindex = 0;
        for( int i=1;i<=nums.length;i++){
            currsum = currsum + nums[i-1];
            pairs[i] = new Pair(currsum,i);
        }
        for( int i=1;i<=nums.length;i++){
            int diff = pairs[i].sum-pairs[i-1].sum;
            if(diff<mindiff){
                mindiff = diff;
                minindex = i-1;
            }
        }
        if(pairs[minindex].index <pairs[minindex+1].index){
            list.add(pairs[minindex].index);
            list.add(pairs[minindex+1].index);
        }
        else {
            list.add(pairs[minindex+1].index);
            list.add(pairs[minindex].index);
        }
        return list;
    }
    private class Pair implements Comparable<Pair>{
        int sum;
        int index;
        Pair(int sum,int index){
            this.sum = sum;
            this.index = index;
        }
        @Override
        public int compareTo(Pair that){
            return this.sum-that.sum;
        }
    }
}
