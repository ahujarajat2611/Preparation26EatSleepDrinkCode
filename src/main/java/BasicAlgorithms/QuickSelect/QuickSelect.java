package BasicAlgorithms.QuickSelect;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by hadoop on 16/10/17.
 */
public class QuickSelect {

    // return the index of the kth smallest number
    // avg. O(n) time complexity
    int quickSelect(List<Integer> a, int lo, int hi, int k) {
        int i = partitionDutch(a,lo,hi);
        // count the nums that are <= pivot from lo
        int m = i - lo + 1;

        // pivot is the one!
        if (m == k) return i;
            // pivot is too big, so it must be on the left
        else if (m > k) return quickSelect(a, lo, i - 1, k);
            // pivot is too small, so it must be on the right
        else return quickSelect(a, i + 1, hi, k - m);
    }
    private static int partitionDutch(List<Integer>nums,int start,int end) {
        int pivot= nums.get(start);
        int left = start;
        int right = end;
        int middle = start;
        while (middle<=right){
            if(nums.get(middle) == pivot){
                middle++;
            }
            else if(nums.get(middle)<pivot){
                Collections.swap(nums,left,middle);
//                swap(nums,left,middle);
                middle++;
                left++;
            }
            else {
                Collections.swap(nums,right,middle);
//                swap(nums,right,middle);
                right--;
            }
        }
        return left;
    }
    private static void swap(int[] array, int startindex, int middle) {
        int temp = array[startindex];
        array[startindex] = array[middle];
        array[middle] = temp;
    }
}