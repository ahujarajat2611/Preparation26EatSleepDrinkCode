package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Given [3, 1, 5, 8]
Return 167
    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

I had some problem understanding the DP formula. In this problem, dp[i][j] represents the maximum coins we can get by bursting balloons in subarray starting from i, ending from j, inclusively. Now we know that for every point x within dp[i][j], we can calculate dp[i][x - 1] and dp[x + 1][j] from previous calculation. The only question is the coins of bursting x. The formula is :

dp[i][j] = Math.max(dp[i][j], dp[i][x - 1] + nums[i - 1]*nums[x]*nums[j + 1] + dp[x + 1][j])

What confuses me is that why the number of coins is nums[i - 1]*nums[x]*nums[j + 1]? What if there are more than 3 balloons between i and j?

The correct way to understand is x represents the last balloon to burst in subarray from i to j that leads to the maximum coins. Since all other balloons between i and j have already been bursted, i, x, and j are adjacent to each other.

Now everything becomes clearer.
 */
public class BurstBallons {
    public int maxCoins(int[] iNums) {
        int n = iNums.length;
        int[] nums = new int[n + 2];
        for (int i = 0; i < n; i++) nums[i + 1] = iNums[i];
        nums[0] = nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        //subarray of len = k
        for (int k = 1; k <= n; k++) {
            //publish
            for (int i = 1; i <= n - k + 1; i++) {
                //end
                int j = i + k - 1;
                //the last balloon to burst that can get the maximum coins.
                for (int x = i; x <= j; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][x - 1] + nums[i - 1] * nums[x] * nums[j + 1] + dp[x + 1][j]);
                }
            }
        }
        return dp[1][n];

    }
}
