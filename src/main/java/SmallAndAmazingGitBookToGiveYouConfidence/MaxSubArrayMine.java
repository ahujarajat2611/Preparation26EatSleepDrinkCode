package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 1/3/18.
 */
public class MaxSubArrayMine {
    public int maxSubArray(int[] nums, int k) {
        if (nums == null || nums.length == 0
                || k <= 0 || k > nums.length) {
            return -1;
        }

        int n = nums.length;
        // status
        int[][] f = new int[n + 1][k + 1];
        // initialize

        for (int j = 1; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                f[i][j] = Integer.MIN_VALUE;
                for (int m = j-1; m < i; m++) {
                    f[i][j] = Math.max(f[i][j], f[m][j-1] + maxSubArray(nums, m, i-1));
                }
            }
        }

        return f[n][k];
    }
    private int maxSubArray(int[] nums, int start, int end) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
