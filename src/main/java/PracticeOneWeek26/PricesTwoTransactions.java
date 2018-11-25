package PracticeOneWeek26;

/**
 * Created by hadoop on 7/12/17.
 */
public class PricesTwoTransactions {
    public int maxProfit(int[] prices) {
        int leftProfit[] = new int[prices.length];
        int rightProfit[] = new int[prices.length];
        int min = prices[0];
        // buy max
        // sell min
        //addd all to see whats the max at each point of the day
        for(int i=1;i<prices.length;i++){
            min = Math.min(min,prices[0]);
            leftProfit[i] = Math.max(leftProfit[i-1],prices[i]-min);
        }
        int max = prices[prices.length-1];
        for(int k = prices.length-2;k>=0;k--){
            max = Math.max(max,prices[k]);
            rightProfit[k] = Math.max(rightProfit[k+1],max-rightProfit[k]);
        }
        int ans =0;
        for(int i=0;i<prices.length;i++){
            ans = Math.max(ans,leftProfit[i]+rightProfit[i]);
        }
        return ans;
    }
    public int maxProfitAgain(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] leftProfit = new int[prices.length];
        int[] rightProfit = new int[prices.length];
        int min = prices[0];    //Default:leftProfit[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - min);
        }
        int max = prices[prices.length - 1];    //Default:rightProfit[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], max - prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, leftProfit[i] + rightProfit[i]);
        }
        return profit;
    }
}