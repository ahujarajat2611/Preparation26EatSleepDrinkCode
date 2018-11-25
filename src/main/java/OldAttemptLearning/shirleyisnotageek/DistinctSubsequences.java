package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
public class DistinctSubsequences {
    public static int sum;
    public int numDistinct(String S, String T) {
        if (S == null || T == null)
            return 0;
        int[][]nums = new int[S.length() + 1][T.length() + 1];

        for(int i = 0; i <= S.length(); i++)
            nums[i][0] = 1;

        for (int i = 1; i <= S.length(); i++)
        {
            for (int j = 1; j <= T.length(); j++)
            {
                nums[i][j] = nums[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1))
                    nums[i][j] += nums[i - 1][j - 1];
            }
        }
        return nums[S.length()][T.length()];
    }

}
/*
Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.
Another DP! And a two dimensional one.

S = "rabbbit";
T = "rabbit";

                 r     a     b
         0     1     2     3
    0   1     0     0     0
r   1   1    1     0      0
a   2   1    1     1     0
b   3   1    1     1     1
b   4   1    1     1     2



Let num[S.length() + 1][T.length() + 1] represents the number of subsequences of any substrings of S can be generated from  any substrings of T. num[i][j] represents the number of subsequences of S.substring(0, i) from T.substring(0, j).

num[i][0] equals 1 because an empty string is a subsequence of any string.
num[0][j] equals 0 because an empty string has no subsequence string.

if S = "rabc", then number of subsequence formed by T = "rab" equals number of subsequence of "rab" formed by T: num[i][j] = num[i - 1][j] if s.charAt(i - 1) != s.charAt(j - 1);
if S = "rabb", then besides number of subsequence of "rab", we also need to add number of sequence of "rab" formed by "ra", because when we add 'b', we can form new subsequences: num[i][j] += num[i - 1][j - 1].
 */