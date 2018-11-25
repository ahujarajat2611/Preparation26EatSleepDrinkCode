package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 23/2/18.
 */
public class Ktransactions_optimized {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            return quickSolve(prices);

        }

        int[][] dp = new int[k + 1][len];

        for (int i = 1; i <= k; i++) {

            int tmpMax = -prices[0];

            for (int j = 1; j < len; j++) {

                // Sell the stock at j: not sell/sell.

                dp[i][j] = Math.max(dp[i][j - 1], tmpMax + prices[j]);

                // Buy the stock: not buy/buy.

                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }

        }

        return dp[k][len - 1];

    }

    public static void main(String[] args) {
        Ktransactions_optimized ktransactions_optimized = new Ktransactions_optimized();

    }

    private int quickSolve(int[] prices) {

        int len = prices.length, profit = 0;

        for (int i = 1; i < len; i++)

            // as long as there is a price gap, we gain a profit.

            if (prices[i] > prices[i - 1]) {

                profit += prices[i] - prices[i - 1];

            }

        return profit;
    }
}
