package BasicAlgorithms.TwoPointers;

/**
 * Created by hadoop on 13/10/17.
 */
public class RemoveElement {
    int remove(int nums[],int val){
        int index =0;
        int i=0;
        while (i<nums.length){
            if(nums[i]!=val){
                nums[index++] = nums[i];
            }
            i++;
        }
        return index;
    }
    int removeandmovevaltoend(int nums[],int val){
        int start = 0;
        int end = nums.length-1;
        while (start<=end){
            if(nums[start] == val){
                swap(nums,start,end);
                end--;
            }
            else {
                start++;
            }
        }
        return start;
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
