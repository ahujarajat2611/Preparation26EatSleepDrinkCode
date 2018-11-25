package PracticeOneWeek26;

/**
 * Created by hadoop on 8/12/17.
 */
public class ClimbingStairs {
    public class Solution {
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
}
