package PracticeOneWeek26;

/**
 * Created by hadoop on 8/12/17.
 */
public class CoinsinLine {
    public boolean firstWillWin(int n) {
        if (n <= 0) {
            return false;
        }
        if (n <= 2) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        dp[2] = true;
        dp[3] = false;
        for (int i = 4; i <= n; i++) {
            dp[i] =  dp[i - 3];
        }
        return dp[n];
    }
}
