package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
public class MinCutsPalindrome {
    /*
Given a string s, cut s into some substrings such that every substring is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
Example
For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
Tags Expand
Dynamic Programming
Thinking process:
DP problem.
Use a isPal to record if any [i ~ j] is Palindrome, true/false
    for any char s[i] and s[j], if s[i] == s[j], then need to check if [i + 1, j - 1] is Palindrome, which is just isPal[i + 1, j - 1].
Use cut[j] to record the minimal cut from char index [0 ~ j]
    by default, cut[j] = j because the worst condition is cut j times at each charactor: none 2+ character palindrome, and split into individual chars.
    update cut[j] by comparing existing cut[j] and (cut[i - 1] + 1).
At the end, return cut[s.length() - 1].
*/
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        boolean[][] isPal = new boolean[length][length];
        int[] cut = new int[length];
        for (int j = 0; j < length; j++) {
            cut[j] = j;
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    if (i > 0) {
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    } else {
                        cut[j] = 0;
                    }
                }
            }//end i_for
        }//end for j_for
        return cut[length - 1];
    }
}
