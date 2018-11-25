package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

*/

/*
Thoughts:
count 'fewest' -> DP.
11 = 5 + 5 + 1, but not = 1 + 1 + 1...+1.
f[x] = fewests num of coins need to accumulate amount x.
f[x] = f[x - coin1] + 1, or f[x - coin2] + 1, f[x - coin3] + 1
Boundary:
x = 1,2,5 -> return 1.
x < 1, return -1.
if can't work at a particular ( 0 ~ x), let's say: we only have 2 and 5 but we want to get f[3], put Integer.MAX_VALUE there.

step:
initialize f[0]
loop over 0 ~ amount, calculate f[x]
*/
public class FeweestCoins {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        final int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) { // 1: 1, 2: 2, 5
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1 && coin != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            dp[i] = dp[i] == Integer.MAX_VALUE? -1 : dp[i];
        }

        return dp[amount];
    }
}
