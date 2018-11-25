package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int pivot = k;
        int start =0;
        int middle = 0;
        int end = nums.length-1;
        while(middle<=end){
            if(nums[middle] == pivot){
                middle++;
            }
            else if(nums[middle] < pivot){
                swap(nums,middle,start);
                start++;
                middle++;
            }
            else{
                swap(nums,end,middle);
                end--;
            }
        }
        return start;
    }
    void swap(int []nums,int start,int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
