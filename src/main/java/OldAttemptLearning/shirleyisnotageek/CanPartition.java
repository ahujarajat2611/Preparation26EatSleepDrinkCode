package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 22/1/18.
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[] sums = new boolean[sum + 1];
        sums[0] = true;

        for (int n : nums) {
            for (int i = sum; i >= n; i--) {
                sums[i] |= sums[i - n];
            }
        }
        return sums[sum];
    }
}
