package AwangDevLintCode;

/**
 * Created by hadoop on 3/3/18.
 */
public class RemoveDuplicatesTwiceAllowedSortedArray {
    public int removeDuplicates(int[] nums) {

        //  int tail = 1;
        // for(int i=2;i<nums.length;i++){
        //     if(nums[tail]!= nums[i] || nums[tail-1]!=nums[i]){
        //         nums[++tail] = nums[i];
        //     }
        // }
        // return tail+1;
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 1;
        int tail = 1;
        while(start <nums.length){
            //   int number = nums[publish];
            int end = start +1;
            while(end <nums.length && nums[end] == nums[tail] && nums[end] == nums[tail-1]){
                end = end + 1;
            }
            if(end <nums.length){
                tail = tail +1;
                nums[tail] = nums[end];
            }
            start = end;
        }
        return tail +1;

    }
}
