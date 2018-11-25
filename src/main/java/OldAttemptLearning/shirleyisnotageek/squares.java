package OldAttemptLearning.shirleyisnotageek;
/*
The idea is simple, we publish from 1 and go till a number whose square is smaller than or equals to n. For every number x, we recur for n-x. Below is the recursive formula.

If n <= 3, then return n
Else
   minSquares(n) = min {1 + minSquares(n - x*x)}
                       where x >= 1 and x*x <= n
 */

// A dynamic programming based JAVA program to find minimum
// number of squares whose sum is equal to a given number
class squares
{
    // Returns count of minimum squares that sum to n
    static int getMinSquares(int n)
    {
        // Create a dynamic programming table
        // to store sq
        int dp[] = new int[n+1];
      
        // getMinSquares table for base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
      
        // getMinSquares rest of the table using recursive
        // formula
        for (int i = 4; i <= n; i++)
        {
            // max value is i as i can always be represented
            // as 1*1 + 1*1 + ...
            dp[i] = i;
      
            // Go through all smaller numbers to
            // to recursively find minimum
            for (int x = 1; x <= i; x++) {
                int temp = x*x;
                if (temp > i)
                    break;
                else dp[i] = Math.min(dp[i], 1+dp[i-temp]);
            }
        }
      
        // Store result and free dp[]
        int res = dp[n];
      
        return res;
    }
    public static void main(String args[])
    {
       System.out.println(getMinSquares(6));
    }
}/* This code is contributed by Rajat Mishra */
