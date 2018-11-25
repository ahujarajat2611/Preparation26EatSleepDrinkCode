package PracticeOneWeek26;

/**
 * Created by hadoop on 7/12/17.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        if (nums == null || nums.length <= 1) {
            return rst;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            long sum = (long)(nums[start] + nums[end]);
            if (target == sum) {
                rst[0] = start + 1;
                rst[1] = end + 1;
                break;
            } else if (target > sum) {
                start++;
            } else {
                end--;
            }
        }//END while
        return rst;
    }
}
