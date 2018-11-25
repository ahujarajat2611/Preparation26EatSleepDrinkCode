package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 25/10/17.
 */
public class RangeSum {
    int numberofelementsinrange(int []num, int lower,int upper){
        int []sum = new int[num.length+1];
        for(int i=1;i<=num.length;i++){
            sum[i] = sum[i-1] + num[i-1];
        }
        int result = 0;
        for(int i=0;i<sum.length;i++){
            for(int j=i+1;i<sum.length;j++){
                if(sum[j] -sum[j]>=lower && sum[j]-sum[i]<=upper){
                    result++;
                }
            }
        }
        return result;
    }
}
