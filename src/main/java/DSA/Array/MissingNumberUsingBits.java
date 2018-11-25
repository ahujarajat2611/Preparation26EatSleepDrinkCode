package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class MissingNumberUsingBits {
    int findMissingNumberUsingBits(int a[], int n) {
        int x1 = 0, x2 = 0;
        for (int i = 0; i < n; i++) {
            x1 = x1 ^ a[i];
        }

        for (int i = 1; i <= n + 1; i++) {
            x2 = x2 ^ i;
        }
        return x1 ^ x2;
    }
}
