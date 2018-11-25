package DSA.PatternMatching;

/**
 * Created by hadoop on 14/2/18.
 */
public class BruteForceMatch {
    int BruteForceMatch(char[] pattern, char[] text) {
        int m = pattern.length;
        int n = text.length;

        for (int i = 0; i <= n - m; i++) {

            int j = 0;
            while (j < m && text[i + j] == pattern[j]) {
                j++;
            }
            if (j == m) {
                System.out.println("Pattern found at " + i);
            }
        }
        return -1;
    }
}
