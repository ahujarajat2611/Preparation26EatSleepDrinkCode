package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class MaxDifference {
    public int maxDiff(int[] a, int n) {
        if (n <= 0)
            return -1;
        int maxDiff = Integer.MIN_VALUE;
        int minSoFar = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - minSoFar > maxDiff) {
                maxDiff = a[i] - minSoFar;
            }
            if (a[i] < minSoFar) {
                minSoFar = a[i];
            }
        }
        return maxDiff;
    }

    public int maxDiffVariation2(int[] a, int n) {
        if (n <= 0)
            return -1;
        int maxDiff = Integer.MIN_VALUE;
        int maxSoFar = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (maxSoFar - a[i] > maxDiff) {
                maxDiff = maxSoFar - a[i];
            }
            if (a[i] > maxSoFar) {
                maxSoFar = a[i];
            }
        }
        return maxDiff;
    }

}
