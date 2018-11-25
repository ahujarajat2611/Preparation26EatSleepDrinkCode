package PracticeOneWeek26;

/**
 * Created by hadoop on 9/12/17.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (flag * nums[i] < flag * nums[i - 1]) {
                swap(nums, i, i - 1);
            }
            flag = -1 * flag;
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
