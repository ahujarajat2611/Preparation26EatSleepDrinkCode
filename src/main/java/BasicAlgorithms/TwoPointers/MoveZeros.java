package BasicAlgorithms.TwoPointers;

/**
 * Created by hadoop on 13/10/17.
 */
public class MoveZeros {
    public static void main(String[] args) {
        int nums[]= {0,1,0,3,12};
        movezero(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    static void movezero(int nums[]){
        int firstZero =-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums,i,++firstZero);
            }
        }
    }
    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
