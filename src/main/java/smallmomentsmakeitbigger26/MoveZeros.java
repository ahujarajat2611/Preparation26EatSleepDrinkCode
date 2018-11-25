package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length ==0){
            return ;
        }
        // have lastindex =-1
        // swap things simply
        int lastindex = -1;
        for(int i=0;i<nums.length ;i++){
            if(nums[i] !=0){
                swap(nums,++lastindex,i);
            }
        }
    }
    void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
