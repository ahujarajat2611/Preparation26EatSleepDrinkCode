package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 2/3/18.
 */
public class BestMaxSubArrayTestedAndWorking {
    public int maxSubArray(int[] nums, int k) {
        if (nums == null || nums.length == 0
                || k <= 0 || k > nums.length) {
            return -1;
        }

        int n = nums.length;
        // status
        int[][] f = new int[k+1][n + 1];
        // initialize

        for (int p = 1; p <= k; p++) {
            for (int i = p; i <= n; i++) {
                f[p][i] = Integer.MIN_VALUE;
                for (int m = p-1; m < i; m++) {
                    f[p][i] = Math.max(f[p][i], f[p-1][m] + maxSubArray(nums, m, i-1));
                }
            }
        }

        return f[k][n];
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



    public int maxSubArrayOptimized(int[] nums, int k) {
        if (nums == null || nums.length == 0
                || k <= 0 || k > nums.length) {
            return -1;
        }

        int n = nums.length;
        // status
        int[][] f = new int[k+1][n + 1];
        // initialize

        for (int p = 1; p <= k; p++) {
            for (int i = p; i <= n; i++) {
                f[p][i] = Integer.MIN_VALUE;

                int curSum = 0;
                int maxSum = Integer.MIN_VALUE;
                for (int m = i-1; m >= p-1; m--) {
                    curSum = Math.max(curSum + nums[m], nums[m]);
                    maxSum = Math.max(maxSum, curSum);

                    f[p][i] = Math.max(f[p][i], f[p-1][m] + maxSum);
                }
            }
        }

        return f[k][n];
    }

}
