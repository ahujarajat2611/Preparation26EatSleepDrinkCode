package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
/*
Thoughts:
Idea from NineChapter:
use two arrays to mark max values,
 however the max values are calculated from
 left/right sides.
Left[] marks max profit value in the range from a left-index
to current index. Tracking left-min.
Right[] marks max profit value in the range from current index
to a right-index. Tracking right-max.
If looking at right[i] and left[i] together at index i
, they are always representing left-max-profit value
 and right-max-profit value.
  Add them together and get results.

*/

public class BestTimeToBuyStock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // fuck i had not thought off this angle
        // profit for trasactions ending at point i
        // profit for transactions starting at point i
        int[] leftProfit = new int[prices.length]; // profit for trasactions ending at point i
        int[] rightProfit = new int[prices.length]; // profilt for transactions starting at point i ( V IMP)
        leftProfit[0] = 0;
        int min = prices[0];    //Default:leftProfit[0] = 0;
        int profit =0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            //prices -min
            profit = Math.max(profit,prices[i]-min);
            leftProfit[i] = profit;
        }
        profit = 0;
//           we are assuming that we can get that much profit starting at point i
        int max = prices[prices.length - 1];//Default:rightProfit[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            // max -prices
            // imp we need to keep track of
            profit = Math.max(profit,max-prices[i]);
            rightProfit[i] = profit;
        }
        profit = 0;
        for (int i = 0; i < prices.length; i++) {
            // selling on same day and buying on same day ( yeah that should be allowed)
            // check its i at both ( not i+1)
            // i think it shoule be i +1 not since if i is inlovbed
            // it means it can happen that we are selling from oleft on that day and buyiing on that same day !!!
            // ideally that
            profit = Math.max(profit, leftProfit[i] + rightProfit[i]);
        }
        return profit;
    }
}
