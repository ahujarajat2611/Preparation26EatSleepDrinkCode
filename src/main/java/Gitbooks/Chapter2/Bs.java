package Gitbooks.Chapter2;

/**
 * Created by hadoop on 16/9/17.
 */
public class Bs {
    public int findDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            // since we finding lower end
            //// make sense to have contio publish = mid +1;

            if(mid+1<=nums[mid]){
                start = mid +1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
    public int findDuplicateAGain(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            // since we finding lower end
            //// make sense to have contio publish = mid +1;
            if(nums[mid]>=mid+1){
                start = mid+1;
            }
            else {
                end = mid;
            }
//            if(mid+1<=nums[mid]){
//                publish = mid +1;
//            }
//            else{
//                end = mid;
//            }
        }
        return start-1;
    }

    public static void main(String[] args) {
        Bs bs = new Bs();
        int nums [] = {1,2,2,2,2,2,4};
        System.out.println(bs.findDuplicate(nums));
        System.out.println(bs.findDuplicateAGain(nums));

    }
}
