package Gitbooks.Chapter2;

/**
 * Created by hadoop on 18/9/17.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return searchRotatedrray(nums,0,nums.length-1,target);

    }
    private int searchRotatedrray(int array[], int low, int high, int target){
        if(array == null || array.length == 0) return -1;
        while (low<high){

            int mid = low + (high-low)/2;

            if(array[mid]<array[high]){
                if(array[mid]<target && target<=array[high]){
                    low = mid +1;
                }
                else {
                    high = mid;
                }

            }
            else {

                if(array[low]<=target && target<=array[mid]){
                    high = mid;
                }
                else {
                    low = mid +1;
                }
            }
        }
        if(array[low] == target) return low;
        return -1;
    }
}
