package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 26/1/18.
 */
public class MaxProfitWithKtransactions {
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
        // JUST LIKE LIS format ... j is ending one transaction point
        // so previous points iterate and calculate so soso fucking simple
        // it is ........
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int val = 0;
                for (int m = 0; m < j; m++) {
                    val = Math.max(a[j] - a[m] + t[i - 1][m], val);
                }
                t[i][j] = Math.max(t[i - 1][j], val);
            }
        }
        return t[k][n - 1];
    }
}
