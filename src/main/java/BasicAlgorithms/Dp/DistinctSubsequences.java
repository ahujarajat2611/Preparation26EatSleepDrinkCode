package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 5/1/18.
 */
public class DistinctSubsequences {
    private  class Solution {
        /**
         * @param S, T: Two string.
         * @return: Count the number of distinct subsequences
         */

        // think top down and then convert it into bottom up !!!
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
    }
}
