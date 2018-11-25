package BasicAlgorithms.Array;

/**
 * Created by hadoop on 19/12/17.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return 2;
        }
        int slow = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[slow - 2]) {
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }
    public int removeDuplicatesAgain(int[] nums) {

        int slow = 2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]>nums[slow-2]){
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }
    public int removeDuplicatesSimple(int[] nums) {
        if (nums.length < 2) {
            return 1;
        }
        int slow = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[slow - 1]) {
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }

    }
