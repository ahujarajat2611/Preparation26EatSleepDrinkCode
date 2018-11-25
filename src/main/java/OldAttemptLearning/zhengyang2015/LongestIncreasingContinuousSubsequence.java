package OldAttemptLearning.zhengyang2015;

/**
 * Created by hadoop on 23/8/17.
 */
public class LongestIncreasingContinuousSubsequence {
    public static void main(String[] args) {
        int array[]={5, 4, 2, 1, 3};
        int ans = longestincreasing(array);
        System.out.println(ans);
    }

    private static int longestincreasing(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return 1;
        }
        int length = 1;
        int max = 0;
        for( int i=1;i<array.length;i++){
            if(array[i]>array[i-1]){
                length++;
            }
            else {
                length =1;
            }
            max = Math.max(max,length);
        }
        length = 1;
        for( int i=array.length-2;i>=0;i--){
            if ( array[i]>array[i+1]){
                length++;
            }
            else {
                length=1;
            }
            max = Math.max(max,length);
        }
        return max;
    }
}
