package AwangDevLintCode;

/**
 * Created by hadoop on 24/2/18.
 */
public class WoodCutMine {
    public int woodCut(int[] L, int k) {
        // write your code here
        long end = Integer.MIN_VALUE;
        for(int x:L){
            end = Math.max(x,end);
        }
        end = end +1;

        long start =0;

        while(start < end){
            long mid = start + (end-start+1)/2;

            /*
            if count is less than k it means we need to decrease the size of wood so that we reach towwards k
            // but here once we reach k we need to increasing wood size since we need to find maximum length so last index search
            technique
            int count = count(mid,L);
            if(count >=k){
                start = mid
            else{
                end = mid-1
            }
             */
            if(count(mid,L) < k){
                end = mid -1;
            }
            else{
                start = mid;
            }
        }
        // as part of tradtionl bs approach check for last thing
        return (int)start;
    }

    int count(long length, int []array){
        int ans =0;
        for(int x:array){
            ans += x/length;
        }
        return ans;
    }
}
