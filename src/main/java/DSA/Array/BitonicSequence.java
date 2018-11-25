package DSA.Array;

import java.util.Arrays;

/**
 * Created by hadoop on 11/2/18.
 */
public class BitonicSequence {
    public int maxLengthOfBitonic(int a[], int n) {
        int lis[] = new int[n];
        int lds[] = new int[n];

        for (int i = 0; i < n; i++) {
            lis[i] = lds[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                lis[i] = lis[i - 1] + 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                lds[i] = lds[i + 1] + 1;
            }
        }

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxLen = Integer.max(maxLen, lis[i] + lds[i] - 1);
        }
        return maxLen;
    }
}
