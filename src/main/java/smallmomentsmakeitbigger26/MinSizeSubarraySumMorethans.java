package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class MinSizeSubarraySumMorethans {
    public int minSubArrayLen(int s, int[] nums) {

        if(nums == null){
            return 0;
        }
        int end =0;
        int start = 0;
        int sum=0;
        int ans= Integer.MAX_VALUE;
        // sliding window nornal
        while (end<nums.length){
            sum = sum + nums[end];
            while (sum>=s){
                ans = Math.min(ans,end-start+1);
                sum = sum-nums[start];
                start++;
            }
            end++;
        }
        return ans;
    }
}