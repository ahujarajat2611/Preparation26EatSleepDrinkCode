package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 22/1/18.
 */
/*
Similar to 3 sum. Note we need to calculate the count, so if sum <= target, total sums we can get is right - left because all pairs (left, right), (left  + 1, right) ...  (right - 1, right) together with nums[i] will lead to a sum smaller than/equal to target.
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i + 3 <= nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum <= target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        return count;
    }
}
