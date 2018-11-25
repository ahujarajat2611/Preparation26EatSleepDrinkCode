package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int currPos = 0;
        int movingPos = 1;
        while (movingPos < nums.length) {
            while(movingPos < nums.length && nums[currPos] == nums[movingPos]) {
                movingPos++;
            }
            if (movingPos < nums.length && nums[currPos] != nums[movingPos]) {
                nums[currPos + 1] = nums[movingPos];
                currPos++;
                movingPos++;
            }
        }
        return currPos + 1;
    }
    public int removeDuplicatesAgain(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int currPos = 0;
        int movingPos;
        for (movingPos = 1; movingPos < nums.length; movingPos++) {
            if (nums[currPos] != nums[movingPos]) {
                nums[currPos + 1] = nums[movingPos];
                currPos++;
            }
        }
        return currPos + 1;
    }
    /*
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
     */
}
