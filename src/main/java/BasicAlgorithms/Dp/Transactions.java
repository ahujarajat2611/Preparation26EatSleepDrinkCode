package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 26/10/17.
 */
public class Transactions {
    public int maxProfit(int[] prices) {
        return maxProfitII(prices, 0);
    }
    private int maxProfitII(int[] prices, int pos) {
        int profit = 0;
        for (int i = pos+1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0)
                profit += diff;
        }
        return profit;
    }
}
