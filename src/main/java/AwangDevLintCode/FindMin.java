package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class FindMin {
    public int findMin(int[] nums) {
        int lo =0;
        int hi = nums.length-1;
        while (lo<hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid] <=nums[hi]){
                if(nums[mid]<nums[hi]) {
                    hi = mid;
                }
                else {
                    hi--;
                }
            }
            else {
                lo = mid+1;
            }

        }
        return lo;
    }
}
