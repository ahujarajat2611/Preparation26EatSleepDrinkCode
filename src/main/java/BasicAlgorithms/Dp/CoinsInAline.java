package BasicAlgorithms.Dp;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 25/2/18.
 */
/*
Coins in a Line II

Question

There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.
Could you please decide the first player will win or lose?
Example
Given values array A = [1,2,2], return true.
Given A = [1,2,4], return false.
Tags

Dynamic Programming Array Game Theory
Related Problems
Hard Coins in a Line III 30 % Medium Coins in a Line





 */
/*
Analysis

Dynamic Planning 4 Elements
State:
dp [i] Now i left a coin, and now the person taking the coin last up to the value of the coin
Function:
i is the total number of coins
sum [i] is the sum of the last i coins
dp[i] = sum[i]-min(dp[i-1], dp[i-2])
Intialize:
dp[0] = 0
dp [1] = corner [n-1]
dp [2] = corner [n-2] + corner [n-1]
Answer:
dp[n]
Can draw a tree diagram to explain:

 */

public class CoinsInAline {
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }
        int n = values.length;
        int[] dp = new int[n + 1];
        boolean[] flag = new boolean[n + 1];

        int[] sum = new int[n + 1];
        int total = 0;
        sum[0] = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum[n - i] = sum[n - i - 1] + values[i];
            total += values[i];
        }
        ConsoleWriter.printArray(sum);
        System.out.println("sum "+search(n, n, dp, flag, values, sum));

        return search(n, n, dp, flag, values, sum) > total / 2;
    }

    public int search(int i, int n, int[] dp, boolean[] flag, int[] values, int[] sum) {
        if (flag[i] == true) {
            return dp[i];
        }
        if (i == 0) {
            dp[i] = 0;
        } else if (i == 1) {
            dp[i] = values[n - 1];
        } else if (i == 2) {
            dp[i] = values[n - 1] + values[n - 2];
        } else {
            dp[i] = sum[i] - Math.min(search(i - 1, n, dp, flag, values, sum), search(i - 2, n, dp, flag, values, sum));
        }
        flag[i] = true;
        return dp[i];
    }

    public static void main(String[] args) {
        CoinsInAline c = new CoinsInAline();
        int []arr = {3,1,4,100,2,4};

        System.out.println(c.firstWillWin(arr));
    }


/*
DP four elements:
State:
dp[i][j] Now also the i-th to j-th coin, and now the person who takes the coin (upper hand) finally takes the value of the coin at most; here is the interval-type DP, the subscript indicates the interval range
Function:
sum[i][j]The sum of the i th to jth coin values
dp[i][j] = sum[i][j] - min(dp[i+1][j], dp[i][j-1]);
Initialize:
dp[i][i] = coin[i]
Answer:
dp[0][n-1]
Using Memorized Search, memory search can optimize time.
Solution
 */

    public boolean firstWillWinOne(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }

        int n = values.length;

        int[][] sum = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        boolean[][] flag = new boolean[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    sum[i][j] = values[j];
                } else {
                    sum[i][j] = sum[i][j - 1] + values[j];
                }
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += values[i];
        }

        return (total / 2) < search(0, n - 1, dp, flag, values, sum);
    }

    public int search(int i, int j, int[][] dp, boolean[][] flag, int[] values, int[][] sum) {
        if (flag[i][j]) {
            return dp[i][j];
        }

        flag[i][j] = true;

        if (i == j) {
            dp[i][j] = values[i];
        } else if (i > j) {
            dp[i][j] = 0;
        } else if (i + 1 == j) {
            dp[i][j] = Math.max(values[i], values[j]);
        } else {
            dp[i][j] = sum[i][j] - Math.min(search(i, j - 1, dp, flag, values, sum), search(i + 1, j, dp, flag, values, sum));
        }

        return dp[i][j];
    }

    /*
    Coins in a Line

Question

There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.
Could you please decide the first play will win or lose?
Example
n = 1, return true.
n = 2, return true.
n = 3, return false.
n = 4, return true.
n = 5, return true.
Challenge
O(n) time and O(1) memory
Tags

Greedy Dynamic Programming Array Game Theory
Related Problems
Hard Coins in a Line III 30 % Medium Coins in a Line II



Dynamic Programming

This problem can be grouped into the game category problem, it should be noted that the game has one after another.
State:
Define a person's status: dp [i], now there are i coins left, now the current coin takers win situation
Function:
Dp [i] = (! Dp [i-1]) || (! Dp [i-2])
Intialize:
dp[0] = false
dp[1] = true
dp[2] = true
Answer:
dp[n]
Thinking about the minimum state and then thinking about the big state -> Small recursion, so very suitable for memory search

     */

    public boolean firstWillWin(int n) {
        boolean[] dp = new boolean[n + 1];
        boolean[] flag = new boolean[n + 1];
        return search(n, dp, flag);
    }

    boolean search(int i, boolean[] dp, boolean[] flag) {
        if (flag[i] == true) {
            return dp[i];
        }
        if (i == 0) {
            dp[i] = false;
        } else if (i == 1) {
            dp[i] = true;
        } else if (i == 2) {
            dp[i] = true;
        } else {
            dp[i] = ! (search(i - 1, dp, flag) && search(i - 2, dp, flag));
        }
        flag[i] = true;
        return dp[i];
    }
}