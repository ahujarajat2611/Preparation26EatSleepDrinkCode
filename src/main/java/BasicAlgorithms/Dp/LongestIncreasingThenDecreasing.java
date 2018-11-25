package BasicAlgorithms.Dp;

import java.util.Arrays;

/**
 * Created by hadoop on 27/12/17.
 */
public class LongestIncreasingThenDecreasing {
    public static void main(String[] args) {
        int n = 9;
        int []array = {1, 7, 4, 9, 5, 3, 8, 7, 2};
        int ans = getMaxlength(array);
        System.out.println(ans);
    }

    private static int getMaxlength(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        // find longest increasing length
        int [] lisdp = new int[array.length];
        // lisdp[i] stores max length of sequence ending at that position
        // always squence of 1 length possibel and ending thrre itself
        Arrays.fill(lisdp,1);
        for(int end=1;end<array.length;end++){
            for(int i=0;i<end;i++){
                if(array[end]>array[i]){
                    // checking for more than only since no duplicates
                lisdp[end] = Math.max(lisdp[end],lisdp[i]+1);
                }
            }
        }

        int []ldsdp = new int[array.length];
        Arrays.fill(ldsdp,1);
        for(int end =array.length-2;end>=0;end--){
            for(int i=array.length-1;i>end;i--){
                // no duplicates
                if(array[end]>array[i]){
                    // checking for max vlaue
                    ldsdp[end] = Math.max(ldsdp[i],ldsdp[i]+1);
                }
            }
        }
        int ans= Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            // subtracting one since we are considering ith element
            // twice
            ans = Math.max(ans,lisdp[i]+ldsdp[i]-1);
        }
        return ans;
    }
}
