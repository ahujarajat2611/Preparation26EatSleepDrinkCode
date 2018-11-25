package PracticeOneWeek26;

/**
 * Created by hadoop on 7/12/17.
 */
public class ProfitKtransactions {
    public int maxProfitWithKTransactions(int[] prices, int k) {
        int n = prices.length;
        int t[][] = new int[k + 1][prices.length];
        for(int i=0;i<k+1;i++){
            t[i][0] = 0;
        }
        for(int j=0;j<n;j++){
            t[0][j] = 0;
        }

        //WATTA solutoon
        for(int i=1;i<=k;i++){
            for(int end =1;end<n;end++){
                int maxvlaue =Integer.MIN_VALUE;
                for(int p=0;p<end;p++){
                    maxvlaue = Math.max(maxvlaue,t[i-1][p]+prices[end]-prices[p]);
                }
                t[i][end] = Math.max(t[i][end-1],maxvlaue);
            }
        }
        return t[k][n-1];
    }
}
