package Algorithms6hourTraining;

/**
 * Created by hadoop on 21/12/17.
 */
public class SubarrayProductlessthank {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        // number of subarrays
        int res = 0;
        int product = 1;
        int left =0;
        // usual product array sum problem where you are trying to calculate the number of subarrays
        // simple two pointer approachin where right goes ahead and left follows it in case we found some mismatch
        // to match it //

        for(int i=0;i<nums.length;i++){
            product = product *nums[i];
            while (product>=k){
                product = product/nums[left++];

            }
            // calcultate all subarrays ending at i andd starting at left ( thats the trend )
            // you always you have to fix one end point
            // all things ending at i
            res = res + i-left+1;
        }
        return res;
    }
}
