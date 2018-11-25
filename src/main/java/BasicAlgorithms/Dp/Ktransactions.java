package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 26/10/17.
 */
public class Ktransactions {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0,2);
    }
    private int dfs(int[] prices, int pos, int k) {
        if (k == 0 || pos == prices.length)
            return 0;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = pos; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            int diff = prices[i] - min;
            if (diff > 0) {
                diff += dfs(prices, i+1, k-1);
            }
            profit = Math.max(profit, diff);
        }
        return profit;
    }
}
