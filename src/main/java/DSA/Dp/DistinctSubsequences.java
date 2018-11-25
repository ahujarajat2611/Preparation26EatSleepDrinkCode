package DSA.Dp;

/**
 * Created by hadoop on 19/2/18.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) return 0;
        if (S.length() < T.length()) return 0;
        if (T.length() == 0) return 1;

        int[][] f = new int[S.length() + 1][T.length() + 1];
        for (int i = 1; i <= S.length(); i++) {
            f[i][0] = 1;
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    f[i][j] = f[i-1][j] + f[i-1][j-1];
                } else {
                    f[i][j] = f[i-1][j];
                }
            }
        }

        return f[S.length()][T.length()];
    }



/**
 *
 */

/**
 * @author Raj
 *
 *         The problem gives two strings, S and T, count the number of distinct
 *         subsequences of T in S. The problem is a bit of ambiguous. It
 *         actually asks that how many distinct subsequences of S which is equal
 *         to T.
 *
 *
 *         Here is an example: S = "rabbbit", T = "rabbit" Return 3.
 *
 *         each time you remove b from rabbbit it forms rabbit so, total 3 ways
 */

    // Time:O(S*T), Space:O(S*T)
    public static int numOfDistinctSequencesOfSInT(String S, String T) {
        int t[][] = new int[S.length() + 1][T.length() + 1];
        t[0][0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            t[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - 1];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[S.length()][T.length()];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String S = "rabbbit", T = "rabbit";
        int res = -1;
        res = numOfDistinctSequencesOfSInT(S, T);
        System.out.println(res);
    }

}
