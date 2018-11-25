package BasicAlgorithms.Greedy;

/**
 * Created by hadoop on 25/1/18.
 */
public class StockProblems {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 0) return 0;
    /*
        My initial capital is 0.
       Initial state at prices[0]
    */

    /* profit is the max total gain up till now with no stock in hand (last action was selling)
       profitNow is the max total gain if I MUST sell at current price */
        int profit = 0, profitNow = 0;
    /* buy is the max total gain up with a stock in hand (last action was buying)
       buyNow is the max total gain if I MUST buy at current price */
        int buy = -prices[0] - fee, buyNow = -prices[0] - fee;

    /*
       Let i be now, prices[i] is current stock price
       The ideas is at each i, we compare the profit gain between buying at i, and NOT buying at i.
       Pick the choice with a better gain.
       Then compare selling at i, and not selling at i. Pick the choice with a better gain.
       This way we'll explore buying and selling at each and every possible price and end up with the best profit.
    */
        for(int i = 1; i < prices.length; i++) {
            //profitNow = sell at current price = max gain from before with a stock in hand (@param buy) + prices[i]
            profitNow = buy + prices[i];
            //buyNow = buy at current price =
            //max gain from before without stock in hand (@param profit) - (transaction fee + prices[i])
            buyNow = profit - fee - prices[i];
            //Compare max former gain (@param profit) and max gain if sell at i (@param profitNow)
            profit = Math.max(profit, profitNow);
            //Compare max former gain with stock in hand (@param buy) and max gain if buy at i (@param buyNow)
            buy = Math.max(buy, buyNow);
        }
        return profit;
    }


    public int maxProfitMine(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int []buy = new int[prices.length];
        int []sell = new int[prices.length];

        buy[0] = -prices[0];
        sell[0]  = 0;

        for(int i=1;i<prices.length;i++){
            buy[i] = Math.max(buy[i-1],sell[i-1]-prices[i]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]-fee);
        }
        return Math.max(buy[prices.length-1],sell[prices.length-1]);
    }
}
