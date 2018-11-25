package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
//dp[k][i+1] = max(dp[k-1][i+1], dp[k][i], max(dp[k-1][j] + prices[i] - prices[j]))  {0 <= j < i}

public class TransactionKAllowed {
    public int maxProfit(int []nums, int k){
        int profit[][] = new int[k+1][nums.length];
        for(int t= 1;t<=k;t++){
            for(int i=0;i<nums.length;i++){
                for(int partition=0;partition<i;partition++) {
                    int transactiondontdo = profit[t-1][i];
                    int alreadydone = 0;
                    if(i>0) {
                         alreadydone = profit[t][i - 1];
                    }
                    int transactiondo = 0;
                    if(nums[i]>nums[partition]) {
                        transactiondo = profit[t - 1][partition] + nums[i] - nums[partition];
                    }
                    int ans = Math.max(alreadydone,Math.max(transactiondo,transactiondontdo));
                    profit[t][i] = Math.max(profit[t][i],ans);
                }
            }
        }
        for(int i=1;i<=k;i++){
            for(int j=0;j<nums.length;j++){
                System.out.print(profit[i][j]);
            }
            System.out.println();
        }
       // System.out.println(profit[1][nums.length-1]);
        return profit[k][nums.length-1];
    }

    public static void main(String[] args) {
        int nums[] = {4, 4, 6, 1, 1, 4, 2, 5};
        int k = 2;
        TransactionKAllowed transactionKAllowed = new TransactionKAllowed();
        System.out.println(transactionKAllowed.maxProfit(nums, 2));
    }
    public int maxProfitWithKTransactions(int[] a, int n, int k) {
        int t[][] = new int[k + 1][n];

        for (int i = 0; i < n; i++) {
            t[0][i] = 0;
        }

        for (int i = 0; i <= k; i++) {
            t[i][0] = 0;
        }

        int val;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                val = Integer.MIN_VALUE;
                for (int m = 0; m < j; m++) {
                    val = Math.max(val, a[j] - a[m] + t[i - 1][m]);
                }
                t[i][j] = Math.max(t[i][j - 1], val);
            }
        }
        return t[k][n - 1];
    }
}
