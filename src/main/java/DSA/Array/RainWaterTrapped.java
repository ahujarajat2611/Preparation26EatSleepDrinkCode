package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class RainWaterTrapped {
    public int rainWaterTrapped(int a[], int n) {
        if (n <= 1)
            return 0;
        int lMax[] = new int[n];
        int rMax[] = new int[n];

        int max_on_left = a[0];
        int max_on_right = a[n - 1];

        for (int i = 1; i < n; i++) {
            lMax[i] = max_on_left;
            max_on_left = Math.max(a[i], max_on_left);
        }

        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = max_on_right;
            max_on_right = Math.max(a[i], max_on_right);
        }

        int t = 0;

        for (int i = 1; i < n - 1; i++) {
            if (a[i] < lMax[i] && a[i] < rMax[i]) {
                t += Math.min(lMax[i], rMax[i]) - a[i];
            }
        }
        return t;
    }
}
