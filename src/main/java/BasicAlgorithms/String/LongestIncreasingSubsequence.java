package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int []lis = new int[nums.length];
        int maxlength=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && lis[j]+1>lis[i]){
                    lis[i] = lis[j]+1;
                }
            }
            maxlength = Math.max(maxlength,lis[i]);
        }
        return maxlength;
    }
}