package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class InterleaveString {
    /*
Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Example
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
Challenge
O(n2) time or better

Tags Expand
Longest Common Subsequence Dynamic Programming

Attempt2: DP[i][j]: boolean that if first S1(i) chars and first S2(j) chars can interleavign first S3(i + j)
Match one char by one char. We have 2 conditions: match s1 or s2 char, Let's do double-for-loop on s1 and s2
1. match s1: s3.charAt(i + j -1) == s1.charAt(i - 1) && DP[i - 1][j]; // makes sure DP[i-1][j] also works before adding s1[i-1] onto the match list
2. match s2: s3.charAt(i + j -1) == s2.charAt(j - 1) && DP[i][j - 1]// similar as above

Note:
Need to initiate the starting conditions with just s1, or just s2
Note2:
DP ususally publish i == 1, and always use (i - 1) in the loop... this is all because we are trying to get DP[i][j], which are 1 index more than length
*/
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null || (s1 == null && s2 == null) || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] DP = new boolean[s1.length() + 1][s2.length() + 1];
        DP[0][0] = true; // empty s1 and s2 would be a working case

        //with just s1:
        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && DP[i - 1][0]) {
                DP[i][0] = true;
            }
        }

        //with just s2:
        for (int j = 1; j <= s2.length(); j++) {
            if (s3.charAt(j - 1) == s2.charAt(j - 1) && DP[0][j - 1]) {
                DP[0][j] = true;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                // you  just missed very imp point
                // if we are considering ith char to be equal to i+j-1 char
                // then si-1 j should also be true !!!!!
                // i + j -1 i-1 s(i-1)(j)// i + j-1 j-1  s(i){j-1)
                if ((s3.charAt(i + j - 1) == s1.charAt(i - 1) && DP[i - 1][j])
                        || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && DP[i][j - 1])) {
                    DP[i][j] = true;
                }
            }
        }
        return DP[s1.length()][s2.length()];
    }
}
