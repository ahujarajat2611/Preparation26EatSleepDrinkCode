package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 24/2/18.
 */
public class MaxSumNonOverlapArrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k, int n) {
        int[][] dp = new int[n + 1][nums.length + 1];
        int[][] index = new int[n + 1][nums.length + 1];
        int tot = 0;
        // prefix sum
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = k; j <= nums.length; j++) {
                int tmpMax = sum[j] - sum[j - k] + dp[i - 1][j - k];
                if (tmpMax > dp[i][j]) {
                    dp[i][j] = tmpMax;
                    index[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j-1];
                    index[i][j] = index[i][j-1];
                }
            }
        }

        int[] ret = new int[n];
        int prev = nums.length;
        for (int i = n; i > 0; i--) {
            ret[i - 1] = index[i][prev];
            prev = ret[i - 1];
        }

        return ret;
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        return maxSumOfThreeSubarrays(nums, k, 3);
    }
}
