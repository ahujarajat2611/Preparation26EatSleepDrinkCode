package BasicAlgorithms.TwoPointers;

/**
 * Created by hadoop on 13/10/17.
 */
public class MaxWater {
    int maxwater(int nums[]){
        int left = 0;
        int right  = nums.length-1;

        int ans = Integer.MIN_VALUE;
        while (left<right){
            if(nums[left]<nums[right]){
                ans = Math.max(ans,(right-left+1)*nums[left]);
                left++;
            }
            else{
                ans = Math.max(ans,(right-left+1)*nums[right]);
                right++;
            }
        }
        return ans;
    }
}
