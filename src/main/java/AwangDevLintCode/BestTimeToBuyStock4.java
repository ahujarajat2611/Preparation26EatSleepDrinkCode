package AwangDevLintCode;

/**
 * Created by hadoop on 23/2/18.
 */
public class BestTimeToBuyStock4 {
    public int maxProfit(int k, int[] prices) {
        if(prices== null || prices.length ==0){
            return 0;
        }

        int n = prices.length;
        int t[][] = new int[k + 1][prices.length];
        for(int i=0;i<k+1;i++){
            t[i][0] = 0;
        }
        for(int j=0;j<n;j++){
            t[0][j] = 0;
        }
// STANDARD PIECE OF ALGO GETS USED EVERYWHERE !!!!!!
        // K BEING THE NUMBER OF TRANSACTIONS
        // WE ITERATE 1 BY ONE ON TRANSACTIONS

        // how many starting points
        // all starting points
        // all options based on that starting points
        // boom done !!!
        for(int i=1;i<=k;i++){
            for(int end =1;end<n;end++){
                int maxvlaue =Integer.MIN_VALUE;
                for(int p=0;p<end;p++){
                    maxvlaue = Math.max(maxvlaue,t[i-1][p]+prices[end]-prices[p]);
                }

                // might be the case last transaction value is negative
                // so in that case i would want to avoid this transaction
                // t[i][end] = Math.max(t[i][end-1])
                // until last transaction we found our anss and thats it
                // we no need to go ahead since last transaction result ight be negative !
// i think i nede to consider case
                // where t[i][end] = math.max(t[i-1][end], .....)
                t[i][end] = Math.max(t[i][end-1],maxvlaue);
            }
        }
        return t[k][n-1];
    }

//    DP: t(i,j) is the max profit for up to i transactions by time j (0<=i<=K, 0<=j<=T).


    public int maxProfitOptimized(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            // since previous to this no profile

            int tmpMax =  t[i-1][0]-prices[0];  // very very standard thinking nothing fancy here
            // till previous step par jo profit tha .. usko buy karlo and then follow usualy cycle !!!
            // also
            for (int j = 1; j < len; j++) {
                // all dependss on k transactions
          //      t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                // i am considering this equation since atmost K tractions
                // there could be less transactions thank K to get max profit
                // hence t[i-1][j] also
                t[i][j] = Math.max(t[i-1][j], Math.max(t[i][j-1],prices[j] + tmpMax));
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }
    public int maxProfitOptimizedNormal(int[] prices) {

//        int temp[] = new int[prices.length];
//        temp[0] = -prices[0];
        if(prices == null || prices.length == 0){
            return 0;
        }
        int tempMax = -prices[0];
        int profitmax = Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            profitmax = Math.max(profitmax,prices[i] + tempMax);
            tempMax = Math.max(tempMax,-prices[i]);
        }
        return Math.max(0,profitmax);
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }






}
