package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 17/12/17.
 */
public class CoinChange {
    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Integer.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
    public static void coinChange(int[] minCoinChanges, int[] coins, int money) {
        int coinsNum = coins.length; //零钱的种类数量
        minCoinChanges[0] = 0; //0元需要0个硬币，这是初始值
        // 对每一分钱都找零，即保存子问题的解以备用，即填表
        for (int cents = 1; cents <= money; cents++) {
            // 当用最小币值的硬币找零时，所需硬币数量最多
            int minCoins = cents;

            // 遍历每一种面值的硬币，看是否可作为找零的其中之一
            for (int kind = 0; kind < coinsNum; kind++) {
                // 若当前面值的硬币小于当前的cents则分解问题并查表
                if (coins[kind] <= cents) {
                    int temp = minCoinChanges[cents - coins[kind]] + 1;
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            // 保存最小硬币数
            minCoinChanges[cents] = minCoins;
            System.out.println("面值为 " + (cents) + " 的最小硬币数 : " + minCoinChanges[cents]);
        }
    }
}
