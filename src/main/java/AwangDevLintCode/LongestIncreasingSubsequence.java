package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class LongestIncreasingSubsequence {
    /*
	Thoughts:
	dp[i] depends on not only dp[i-1], but also [i-1] ...[0].
	So it has to be double-for loop.
	Each sub-for loop on i, traverse 0 ~ j(j<=i) to find largest number to put on dp[i]
	fn:
		dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1
	init:
		dp[i] initally all = 1. (i = 0 ~ n). If no other number meets the requirement, at least it has itself.
	Result:
		dp[n - 1]

	Note: nums[j] <= nums[i] is the 'increasing' requirement
	dp[j] + 1 means: best we can do at dp[j] + 1, is this better than what we already have on dp[i]?

*/
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp  = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]){
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
