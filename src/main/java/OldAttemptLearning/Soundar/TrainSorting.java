package OldAttemptLearning.Soundar;

import java.util.Arrays;

/**
 * Created by hadoop on 12/8/17.
 */
public class TrainSorting {
    public static void main(String[] args) {
        int array[] ={1,3,2,4,5,6};
        int ans = lis(array);
    }

    private static int lis(int[] array) {
        int lisarray[] = new int[array.length];
        Arrays.fill(lisarray,1);
        int max = Integer.MAX_VALUE;
        for( int end= 1;end<array.length;end++){
            for( int i=0;i<end;i++){
                if(array[i]<array[end] && lisarray[end]<lisarray[i]+1){
                    lisarray[end] = lisarray[i]+1;
                    max = Math.max(max,lisarray[end]);
                }
            }
        }

        int ldsarray[] = new int[array.length];
        Arrays.fill(ldsarray,1);
        int maxdis = Integer.MAX_VALUE;
        for(int end = 1;end<array.length;end++){
            for( int i=0;i<end;i++){
                if(array[end]<array[i] && ldsarray[end]<ldsarray[i]+1){
                    ldsarray[end] = ldsarray[i]+1;
                    maxdis = Math.max(maxdis,ldsarray[end]);
                }
            }
        }
        int maxlenth = maxdis;
        for(int i=0;i<lisarray.length;i++){
            if(maxlenth<lisarray[i]+ldsarray[i]-1){
                maxlenth = lisarray[i]+ldsarray[i]-1;
            }
        }
        return maxlenth;
    }
}
