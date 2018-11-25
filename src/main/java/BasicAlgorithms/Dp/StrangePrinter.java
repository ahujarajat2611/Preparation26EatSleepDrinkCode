package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 4/1/18.
 */
public class StrangePrinter {
    private class Solution {
        public int strangePrinter(String s) {
            int l = s.length();
            t_ = new int[l][l];
            return turn(s.toCharArray(), 0, l - 1);
        }

        // Minimal turns to print s[i] to s[j]
        private int turn(char[] s, int i, int j) {
            // Empty string
            if (i > j) return 0;
            // Solved
            if (t_[i][j] > 0) return t_[i][j];
            // Default behavior, print s[i] to s[j-1] and print s[j]
            int ans = turn(s, i, j-1) + 1;
            for (int k = i; k < j; ++k)
                if (s[k] == s[j])
                    ans = Math.min(ans, turn(s, i, k) + turn(s, k + 1, j - 1));

            return t_[i][j] = ans;
        }

        private int[][] t_;
    }
}
