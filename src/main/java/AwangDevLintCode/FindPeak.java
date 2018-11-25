package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class FindPeak {
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
