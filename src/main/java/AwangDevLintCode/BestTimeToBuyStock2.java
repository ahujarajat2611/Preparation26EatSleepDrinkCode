package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Thought:
In this case, since we know the
entire stock price for all
days in the array, we want to this:
Sell it at nearest peek price
and buy it on the next dropped price,
then sell again at next peek.
Two pointers,
publish and peek, to track the starting point and the peek.
Two while loop:
While loop on publish, until publish reaches the last 2nd index,
we only have 1 option to sell.
Inner while loop that finds the peek from publish.
Note: peek always has index
>= publish+1.
Sum up all profit and return it.
Tricky thing: we are looking for max profit, but does not require to
sell the stock by end of array.
So if the price is dropping, we are not selling and we are not losing/winning anything.

*/
public class BestTimeToBuyStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int curr = 0;
        int profit = 0;
        int peek = 1;
        while(curr < prices.length) {
            while (peek < prices.length && prices[peek - 1] <= prices[peek]) {
                peek++;
            }
            // sold price - bought price
            profit += prices[peek - 1] - prices[curr];
            // bought at dropped price
            curr = peek;
            peek = curr + 1;
        }
        return profit;
    }

    // two pointer approach mine
    // start < length
    // end = start +1
    // travese end
    // profit = ptofit + array[end-1] -start ( thats trickyyyyy)
    // later shift start to end
    public int maxProfitAgainTwoPointerKindOfAppraoachWithAsManyTransactoins(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int start = 0;
        int profit = 0;
        int end = 1;
        while(start < prices.length) {
            end = start +1;
            while (end < prices.length && prices[end - 1] <= prices[end]) {
                end++;
            }
            // sold price - bought price
            profit += prices[end - 1] - prices[start];
            // bought at dropped price
            start = end;
        }
        return profit;
    }


    /*
    DFS approach
     */
    public int maxProfitDFS(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        return Math.max(dfs(prices, 1, true) - prices[0], dfs(prices, 1, false));
    }
    private int dfs(int[] prices, int index, boolean sellStatus) {
        if (index == prices.length - 1) {
            return sellStatus ? prices[index] : 0;
        }
        int profit = 0;
        for (int i = index; i < prices.length; i++) {
            //No action
            profit = Math.max(profit, dfs(prices, i + 1, sellStatus));
            //Sell or buy:
            int levelDelta = sellStatus ? prices[i] : - prices[i];
            profit = Math.max(profit, dfs(prices, i + 1, !sellStatus) + levelDelta);
        }
        return profit;
    }
}
