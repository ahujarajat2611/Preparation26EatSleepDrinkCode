package OldAttemptLearning.dp;

import java.util.Arrays;

/**
 * Created by hadoop on 11/8/17.
 */
public class lineareq {
    public static void main(String[] args) {
        int array[] = {1,3,5,7};
        int ans = 4;
        //1,1,1,1
        //3,1
        //2,2
        //2,1,1
        int solutions = solutionstotal(array,ans);
        System.out.println("sol"+solutions);
    }

    private static int solutionstotal(int[] array, int ans) {
        int lookup[] = new int[ans+1];
        Arrays.fill(lookup,0);
        lookup[0] = 1;
            for( int j=0;j<array.length;j++){
                for( int i=0;i<=ans;i++){
                    if(i-array[j]>=0) {
                    lookup[i] = lookup[i] + lookup[i - array[j]];
                }
            }
        }
        return lookup[ans];
    }
}
