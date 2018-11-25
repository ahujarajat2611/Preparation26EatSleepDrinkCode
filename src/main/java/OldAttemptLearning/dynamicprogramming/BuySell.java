package OldAttemptLearning.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by hadoop on 3/8/17.
 */
public class BuySell {
    public static void main(String[] args) {
        int[] yourArray = { 7, 1, 5, 3, 6, 4 };
        Integer[] data = new Integer[20];
        Arrays.fill(data,new Integer(-1));
        int max = maxprofit(data);
    }

    private static int maxprofit(Integer[] data) {
        int min = Integer.MAX_VALUE;
        int diff = 0;
        for( int i=0 ;i<data.length;i++){
            if(data[0]<min){
                min = data[i];
            }
            if(data[i]-min >diff){
                diff = data[i]-min;
            }
        }
        return diff;
    }
}
