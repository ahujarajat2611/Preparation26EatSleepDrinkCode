package BasicAlgorithms.Array;

/**
 * Created by hadoop on 24/1/18.
 */
public class SetMismatch {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // similiar to first missing nuber
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) return new int[]{nums[i], i+1};
        }
        return null;
    }
}
