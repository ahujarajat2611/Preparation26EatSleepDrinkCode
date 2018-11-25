package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 13/12/17.
 */
public class TotalPalindromeSubsequences {

}

// Java code to Count Palindromic Subsequence
// in a given String
class GFG
{
    // Function return the total palindromic
    // subsequence
    static int countPS(String str)
    {
        int N = str.length();

        // create a 2D array to store the count
        // of palindromic subsequence
        int[][] cps = new int[N+1][N+1];

        // palindromic subsequence of length 1
        for (int i = 0; i < N; i++)
            cps[i][i] = 1;

        // check subsequence of length L is
        // palindrome or not
        for (int L=2; L<=N; L++)
        {
            for (int i = 0; i < N; i++)
            {
                int k = L + i - 1;
                if (k < N){
                    if (str.charAt(i) == str.charAt(k))
                        cps[i][k] = cps[i][k-1] +
                                cps[i+1][k] + 1;
                    else
                        cps[i][k] = cps[i][k-1] +
                                cps[i+1][k] -
                                cps[i+1][k-1];
                }
            }
        }

        // return total palindromic subsequence
        return cps[0][N-1];
    }

    // Driver program
    public static void main(String args[])
    {
        String str = "abcb";
        System.out.println("Total palindromic "+
                "subsequence are : "
                + countPS(str));
    }
}
// This code is contributed by Sumit Ghosh


/*
Initial Values : i= 0, j= n-1;

CountPS(i,j)
// Every single character of a string is a palindrome
// subsequence
if i == j
   return 1 // palindrome of length 1

// If first and last characters are same, then we
// consider it as palindrome subsequence and check
// for the rest subsequence (i+1, j), (i, j-1)
Else if (str[i] == str[j)]
   return   countPS(i+1, j) + countPS(i, j-1) + 1;

else
   // check for rest sub-sequence and  remove common
   // palindromic subsequences as they are counted
   // twice when we do countPS(i+1, j) + countPS(i,j-1)
   return countPS(i+1, j) + countPS(i, j-1) - countPS(i+1, j-1)
If we draw recursion tree of above recursive solution, we can observe overlapping Subprolems. Since the problem has overlapping subproblems, we can solve it efficiently using Dynamic Programming. Below is Dynamic Programming based solution.
 */