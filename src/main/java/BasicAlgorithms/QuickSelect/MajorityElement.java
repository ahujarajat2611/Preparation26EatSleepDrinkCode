package BasicAlgorithms.QuickSelect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 16/10/17.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int getmedian = getmedian(nums);
        return getmedian;
        //
    }

    private int getmedian(int[] nums) {
        return quickSelect(nums,0,nums.length-1,nums.length/2+1);
    }

    private int quickSelect(int []nums, int lo, int hi, int k) {
        if(lo>hi){
            return -1;
        }
        int partitionindex = dutchpartition(nums,lo,hi);
        System.out.println("par"+partitionindex);
        int size =partitionindex-lo+1;
        if(size == k){
            return nums[partitionindex];
        }
        else if(size<k){
            return quickSelect(nums,partitionindex+1,hi,k-size);
        }
        else {
            return quickSelect(nums,lo,partitionindex-1,k);
        }

    }

    private int dutchpartition(int[] nums, int lo, int hi) {
        int start = lo;
        int high = hi;
        int middle = lo;
        int pivot = nums[(lo+hi)/2];
        while(middle<=high) {
            if (nums[middle] > pivot) {
                swap(nums, middle, high);
                high--;
            } else if (nums[middle] < pivot) {
                swap(nums, start, middle);
                start++;
                middle++;
            } else {
                middle++;
            }
        }
        return start;
    }

    void swap(int[] array, int startindex, int middle) {
        int temp = array[startindex];
        array[startindex] = array[middle];
        array[middle] = temp;
    }
    public static void main(String args[]){
        int array[]={3,2,3};
        MajorityElement majorityElement = new MajorityElement();
        // majority element will be median for sure !!! // since it repeats more than n/2 times
        // it will me median for sure !!!!!!!!! so lets find out nums.length +1 /2 largest number
        majorityElement.getmedian(array);
    }
}