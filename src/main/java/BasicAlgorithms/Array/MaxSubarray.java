package BasicAlgorithms.Array;

import java.util.HashMap;

/**
 * Created by hadoop on 12/10/17.
 */
public class    MaxSubarray {
    public static void main(String[] args) {
        int []nums = {2,3,1,2,4,3};
        int sum = 7;
        System.out.println(maxSubArrayLen(nums,sum));
    }
    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1);
        int sum =0;
        int maxlength = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            if(hashMap.containsKey(sum-k)){
                maxlength = Math.max(maxlength,(i-hashMap.get(sum-k)));
            }
            hashMap.put(sum,i);
        }
        return maxlength;
    }
}
