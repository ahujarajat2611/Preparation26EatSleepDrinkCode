package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class MinJumpsReachEnd {
    public int minJumpsToReachEnd(int a[], int n) {
        if (n <= 0)
            return Integer.MAX_VALUE;
        int t[] = new int[n];

        if (a[0] <= 0)
            return Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            t[i] = Integer.MAX_VALUE;
        }
        t[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + a[j] >= i) {
                    t[i] = Math.min(t[i], 1 + t[j]);
                }
            }
        }
        return t[n - 1];
    }
}
