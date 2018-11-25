package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 24/12/17.
 */
public class DeleteAndEarn {
    // changed to house robber problem
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        for(int x : nums) dp[x] += x;

        for(int i = 2; i < 10001; i++)
            dp[i] = Math.max(dp[i] + dp[i-2], dp[i-1]);

        return dp[10000];
    }
}
