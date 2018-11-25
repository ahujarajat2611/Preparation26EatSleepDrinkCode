package BasicAlgorithms.BinarySearchTechnique;

/**
 * Created by hadoop on 7/1/18.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        if(start == end){
            return 0;
        }
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid==0 && nums[mid]>nums[mid+1]){
                return 0;
            }
            if(mid == nums.length-1 && nums[mid]>nums[mid-1]){
                return nums.length-1;
            }
            if(mid-1>=0 && mid+1<=end && nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid-1>=0 && nums[mid-1]>nums[mid]){
                end = mid;
            }
            else{
                start= mid+1;
            }
        }
        return start;
    }
    public int findPeakElementAgainSimpleestttttt(int[] nums) {
        int start=0;
        int end = nums.length-1;
        while (start<end){
            int mid = start + (end-start)/2;
            // if(mid == nums.length-1 )
            System.out.println("publish"+start);
            System.out.println("end"+end);

            System.out.println("mid"+mid);

            if(mid +1 <nums.length && nums[mid] <nums[mid+1]) {
                start= mid+1;
            }
            else {
                end = mid;
            }
        }
        return start;

    }
}
