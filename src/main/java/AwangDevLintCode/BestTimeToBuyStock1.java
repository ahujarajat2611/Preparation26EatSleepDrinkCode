package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*

Bruforce - buy in on any given day (or not buy), and
 try to sell on
any later days; find the max profit; but it timesout.
 */
/*
Lots of calculations are redundant:
 for example,
if we know buyin with 1 is cheapest, we don't need to buyin at
5, 3, 6, 4 later on; we'll only sell on higher prices.
How about storing the min[i]all the time?
min[i]: from 0 ~ i the minimum
Goal: find max of (prices[i] - min[i]) that gives best profit.


 */
public class BestTimeToBuyStock1 {
    public int maxProfitBruteForce(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        // you can pick point and from there onwards go forward to check all points where you get max reuslt
        // in stocks problem !!!!!
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int[] min = new int[prices.length];
        min[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // keeping track of mins possible
            min[i] = Math.min(min[i - 1], prices[i]);
            // then keeping track of max profit can be earned out !!!
            profit = Math.max(profit, prices[i] - min[i]);
        }
        return profit;
    }
}
