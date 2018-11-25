package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 30/1/18.
 */
public class KthSum {
    int kSumshort(int A[], int k, int target) {
        if (target < 0) {
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[k + 1][target + 1];
        // very imp iniitlizaton here
        dp[0][0] = 1;
        // treat it as backup sum
        // and later add kth layer that aobolutely make sens e

        for (int i = 1; i <= len; i++) {
            for (int t = target; t > 0; t--) {
                for (int j = 1; j <= k; j++) {
                    if (t - A[i - 1] >= 0) {
                        dp[j][t] += dp[j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        return dp[k][target];
    }
}
