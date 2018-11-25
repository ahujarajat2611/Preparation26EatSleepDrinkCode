package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
public class LCS {
    public static int longestCommonSubsequence (String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0)
            return 0;
        int len1 = a.length();
        int len2 = b.length();
        int[][] lcs = new int[len1 + 1][len2 + 1];
        lcs[0][0] = 0;
        for (int j = 0; j <= len2; j++)
            lcs[0][j] = 0;
        for (int i = 0; i <= len1; i++)
            lcs[i][0] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcs[i][j] = Math.max(Math.max(lcs[i - 1][j], lcs[i][j - 1]), lcs[i - 1][j - 1] + 1);
                }
                else {
                    lcs[i][j] = Math.max(Math.max(lcs[i - 1][j], lcs[i][j - 1]), lcs[i - 1][j - 1]);
                }
            }
        }
        return lcs[len1][len2];
    }
}
