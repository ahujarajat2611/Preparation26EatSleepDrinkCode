package DSA.Dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hadoop on 22/2/18.
 */
public class FindAllPossiblePalindromes {
    public Set<String> allPossiblePalindromes(String str) {
        Set<String> set = new HashSet<>();
        int n = str.length();
        char a[] = str.toCharArray();
        boolean[][] t = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            t[i][i] = true;
            set.add(Character.toString(a[i]));
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (l == 2) {
                    if (a[i] == a[j]) {
                        t[i][j] = true;
                    }
                } else {
                    if (a[i] == a[j]) {
                        t[i][j] = t[i][j] || t[i + 1][j - 1];
                    }
                }
                if (t[i][j])
                    set.add(str.substring(i, j + 1));
            }
        }
        return set;
    }
}
