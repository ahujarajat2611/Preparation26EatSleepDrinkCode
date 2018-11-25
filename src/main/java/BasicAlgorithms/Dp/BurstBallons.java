package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 26/10/17.
 */
public class BurstBallons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int num[] = new int[n+2];
        num[0] = 1;
        for (int i = 0; i < n; i++)
            num[i+1] = nums[i];
        num[n+1] = 1;

        return dfsCache(num, 1, n);
    }

    private int dfsCache(int[] num, int L, int R) {
        int n = R-L+1+2;
        int[][] cache = new int[n][n];

        return dfsCache(num, L, R, cache);
    }
    private int dfsCache(int[] num, int L, int R, int[][] cache) {
        if (cache[L][R] != 0)
            return cache[L][R];
        int coins = 0;
        for (int i = L; i <= R; i++) {
            int l = dfsCache(num, L, i-1, cache);
            int r = dfsCache(num, i+1, R, cache);
            int val = num[L-1]*num[i]*num[R+1] + l + r;
            coins = Math.max(coins, val);
        }
        cache[L][R] = coins;
        return coins;
    }

}
