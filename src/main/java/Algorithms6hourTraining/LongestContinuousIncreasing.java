package Algorithms6hourTraining;

/**
 * Created by hadoop on 21/12/17.
 */
/// keep increasing count
// not match bring back count to 1
// things dont match start frmo Zero thats the usual trend it is

public class LongestContinuousIncreasing {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1, cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                cnt++;
                // keep track of max always
                res = Math.max(res,cnt);
            }
            else {
                cnt=1;
            }
        }
        return res;
    }
}