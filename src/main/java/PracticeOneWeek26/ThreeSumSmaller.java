package PracticeOneWeek26;

import java.util.Arrays;

/**
 * Created by hadoop on 7/12/17.
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                if(nums[i]+nums[left]+nums[right]>=target){
                    right--;
                }
                else {
                    result = result + (right-left);
                    left++;
                }
            }
        }
        return result;
    }
}