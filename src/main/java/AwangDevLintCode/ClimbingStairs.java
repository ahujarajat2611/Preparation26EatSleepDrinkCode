package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
 3.25.2016 recap DP
    DP[i] is dependent on wether it was reached by 2 steps or just 1 step:
    DP[i] = DP[i - 1] + DP[i - 2]
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] DP = new int[n + 1];
        DP[0] = 1;
        DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        return DP[n];
    }
}
