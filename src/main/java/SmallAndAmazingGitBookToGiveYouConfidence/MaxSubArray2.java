package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class MaxSubArray2 {
    public int maxSub2arrays(int []temp){
        int size = temp.length;
        int []left = new int[size];
        int []right = new int[size];
        int currentSum=0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<temp.length;i++) {
            currentSum = Math.max(temp[i], currentSum + temp[i]);
            maxSum = Math.max(currentSum, maxSum);
            left[i] = maxSum;
        }
        currentSum = 0;
        maxSum = Integer.MAX_VALUE;
        for(int i=temp.length-1;i>=0;i--){
            currentSum = Math.max(currentSum+temp[i],temp[i]);
            maxSum = Math.max(maxSum,currentSum);
            right[i] = maxSum;
        }
        maxSum = Integer.MIN_VALUE;
        for(int i=0;i<temp.length-1;i++){
            maxSum= Math.max(maxSum,left[i]+right[i+1]);
        }
        return maxSum;
    }
}
