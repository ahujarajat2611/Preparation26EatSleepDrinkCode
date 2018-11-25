package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
/*
There are a row of n houses, each house can be painted with one of the k colors.
The cost of painting each house with a certain color is different.
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix.
For example, costs[0][0] is the cost of painting house 0 with color 0;
costs[1][2] is the cost of painting house 1 with color 2, and so on...

Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
*/


/*
Thoughts:
Min cost, DP.
If dp[i] represents the min cost of painting leading i-1 houses, then consider how to build dp[i]:
It'll be dp[i - 1] + int[i][?] cost. However, we don't know what was choen on index i -1, so it may require a round of traverse. Think about storing the status.
dp[i][j], represents the min of the leading (i - 1) houses' cost, also at index i - 1, color j was chosen

if chosen j at index i, loop over all possibilities at i - 1 index.
dp[i][j] = Math.max(dp[i - 1][0 ~ k] + costs[i][j])
*/


public class PaintHouse2 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        } else if (costs.length == 1 && costs[0].length == 1) {
            return costs[0][0];
        }
        int minCost = Integer.MAX_VALUE;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n + 1][k];
        // Paint 0 houese should be initialized with 0 cost
        for (int j = 0; j < k; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) { // iterate over house #
            for (int j = 0; j < k; j++) { // choose color
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < k; m++) { // choose adjacent color
                    if (m == j) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][m] + costs[i - 1][j]);
                }
                if (i == n) {
                    minCost = Math.min(minCost, dp[i][j]);
                }
            }

        }
        return minCost;
    }
}
