package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class MaxProfitKtransactions {
    public int maxProfitWithKTransactions(int a[], int n, int k) {
        if (n <= 1)
            return 0;
        int t[][] = new int[k + 1][n];
        for (int i = 0; i < n; i++) {
            t[0][i] = 0;
        }
        for (int i = 0; i <= k; i++) {
            t[i][0] = 0;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int val = 0;
                for (int m = 0; m < j; m++) {
                    val = Math.max(a[j] - a[m] + t[i - 1][m], val);
                }
                // VERY VERY IMP ...
                // SAYING MAX PROFIT USING I TRANSACTION
                // MAXX PROFIT I-1 TRANSACTIONS UNTIL J
                t[i][j] = Math.max(t[i - 1][j], val);
            }
        }
        return t[k][n - 1];
    }
    public int maxProfitWithAnyNumberOfTransactions(int a[], int n) {
        if (n <= 1)
            return 0;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1])
                profit += a[i] - a[i - 1];
        }
        return profit;
    }
    public int maxProfitWith1Transactions(int a[], int n) {
        if (n <= 1)
            return 0;
        int min_so_far = a[0];
        int max_profit = 0;
        for (int i = 1; i < n; i++) {
            max_profit = Math.max(a[i] - min_so_far, max_profit);
            min_so_far = Math.min(min_so_far, a[i]);
        }
        return max_profit;
    }
}
