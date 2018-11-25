package BasicAlgorithms.TwoPointers;

import java.util.Arrays;

class Duplicates {
 public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid+1<=nums[mid]){
                start = mid +1;
            }
            else{
                end = mid;
            }
        }
        return nums[start];
    }

}