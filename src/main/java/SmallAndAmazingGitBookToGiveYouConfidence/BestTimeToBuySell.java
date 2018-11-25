package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class BestTimeToBuySell {
    public int timeToBuy(int []nums){
        int []leftProfit = new int[nums.length];
        int minprice = nums[0];
        for(int i=1;i<nums.length;i++){
            leftProfit[i] = Math.max(leftProfit[i-1],nums[i]-minprice);
            minprice = Math.min(minprice,nums[i]);
        }
        int []rightprofit = new int[nums.length];
        int maxprice = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            rightprofit[i] = Math.max(rightprofit[i+1],maxprice-nums[i]);
            maxprice = Math.max(maxprice,nums[i]);
        }
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            ans = Math.max(ans,leftProfit[i]+rightprofit[i]);
        }
        return ans;
    }
    public int maxProfitUnllimitedTransactions(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public int maxProfitOnTransaction(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
