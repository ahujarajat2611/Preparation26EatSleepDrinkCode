package DSA.Array;

import java.util.Arrays;

/**
 * Created by hadoop on 11/2/18.
 */
public class TwoElementsSUmCloserToZero {
    public void twoElementsSumCloseToZero(int a[], int n) {
        Arrays.sort(a);

        int l = 0, r = n - 1;
        int minX = -1, minY = -1;
        int minSum = Integer.MAX_VALUE, sum;
        while (l < r) {
            sum = a[l] + a[r];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                minX = a[l];
                minY = a[r];
            }

            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("minX=" + minX + ",minY=" + minY);
    }
}
