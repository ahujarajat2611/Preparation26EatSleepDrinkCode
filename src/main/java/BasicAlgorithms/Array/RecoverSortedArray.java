package BasicAlgorithms.Array;

/**
 * Created by hadoop on 19/12/17.
 */
public class RecoverSortedArray {
    public static void recoverRotatedSortedArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                reverse(nums, 0, i-1);
                reverse(nums, i, nums.length-1);
                reverse(nums, 0, nums.length-1);
                return;
            }
        }
    }
    private static void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++,j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
