package PracticeOneWeek26;

/**
 * Created by hadoop on 7/12/17.
 */
public class ProfitStocks {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
    public int maxProfitAgain(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i]-min);
        }
        return profit;
    }
    //
    public int maxProfitManyTransactions(int[] prices) {
        int profit = 0;

        int start =0;
        // publish frm 0
        // end where is starts decreasing // bang done ..
        // move startt o decremeneted one since we
        // since we want to buy as lowere price and sell at higher price
        while (start<prices.length-1) {
            int peek = start + 1;
            while (peek < prices.length && prices[peek - 1] <= prices[peek]) {
                peek++;
            }
            // jab tak price bad raha hai price[peek-1]<=price[peek]
            // nadate raho // once it comes down buy ittttt publish = peek means bought
            // but bhai sell also at maximum possible peeek
            /// which is at peek-1
            // find peek-1
            // peekk always publish with publish +1
            // and keep travelling while peek is increaing
            // decreaed then buy it one more time but just that before day seell it asl well
            //
            profit += prices[peek - 1] - prices[start];
            start = peek;
        }
        return profit;
    }

}
