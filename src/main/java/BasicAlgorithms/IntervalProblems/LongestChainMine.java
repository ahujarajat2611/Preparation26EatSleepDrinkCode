package BasicAlgorithms.IntervalProblems;

/**
 * Created by hadoop on 28/2/18.
 */
import java.util.*;
public class LongestChainMine {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int []a,int []b){
                return a[1]-b[1];
            }
        });

        int ans =1;
        int []prev = pairs[0];
        for(int []cur:pairs){

            if(cur[0]<=prev[1]){
                // pverlap
                // prev[1] = cur[1];
            }
            else{
                ans++;
                prev = cur;
            }
        }
        return ans;

    }
    public int findLongestChainDP(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int dp[] = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int end = 1; end < pairs.length; end++) {
            for (int i = 0; i < end; i++) {
                if (pairs[i][1] < pairs[end][0] && dp[i] + 1 > dp[end]) {
                    dp[end] = dp[i] + 1;
                }
            }
        }
        return dp[pairs.length - 1];
    }
}
