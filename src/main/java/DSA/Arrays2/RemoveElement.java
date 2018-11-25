package DSA.Arrays2;

/**
 * Created by hadoop on 21/2/18.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
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
}
