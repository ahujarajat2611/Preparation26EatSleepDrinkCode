package PracticeOneWeek26;

/**
 * Created by hadoop on 7/12/17.
 */
public class BurstBallons {
    int[][] dp;
    int[] values;
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        dp = new int[n + 2][n + 2];

        //Initialize new array
        values = new int[n + 2];
        values[0] = values[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            values[i] = nums[i - 1];
        }

        return DP(1, n);
    }

    public int DP(int i, int j){
        if (dp[i][j] > 0) {//momorization
            return dp[i][j];
        }
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], DP(i, x - 1) + values[i-1]*values[x]*values[j+1] + DP(x + 1, j));
        }
        return dp[i][j];
    }
    public int Dpagain(int i,int j){
        if(dp[i][j]>0){
            return dp[i][j];
        }

        for(int k =i;k<=j;k++){
            dp[i][j] = Math.max(dp[i][j],Dpagain(i,k-1) +values[i-1]*values[k]*values[j+1] + Dpagain(k+1,j));
        }
        return dp[i][j];
    }

    public static int maxCoinsAgain(int a[]) {
        if (null == a || a.length == 0)
            return 0;
        int n = a.length;

        int t[][] = new int[n][n];

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i; k <= j; k++) {
                    int left = 0, right = 0;
                    int lvalue = 1, rvalue = 1;

                    if (i != 0) {
                        lvalue = a[i - 1];
                    }

                    if (j != n - 1) {
                        rvalue = a[j + 1];
                    }
                    if (i != k) {
                        left = t[i][k - 1];
                    }

                    if (j != k) {
                        right = t[k + 1][j];
                    }
                    t[i][j] = Math.max(t[i][j], left + right + (lvalue * rvalue * a[k]));
                }
            }
        }
        return t[0][n - 1];
    }

}
