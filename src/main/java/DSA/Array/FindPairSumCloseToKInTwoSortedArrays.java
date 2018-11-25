package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class FindPairSumCloseToKInTwoSortedArrays {
    public void findPairSumCloseToKInTwoSortedArrays(int a[], int m, int b[], int n, int k) {
        int l1, r2, x, y;
        l1 = 0;
        r2 = n - 1;

        int diff, minDiff = Integer.MAX_VALUE;
        x = y = Integer.MAX_VALUE;
        while (l1 < m && r2 >= 0) {
            diff = a[l1] + b[r2] - k;

            if (Math.abs(diff) < minDiff) {
                minDiff = diff;
                x = a[l1];
                y = b[r2];
            }

            if (diff > 0)
                r2--;
            else if (diff < 0)
                l1++;
            else {
                System.out.println("x=" + x + ",y=" + y);
                return;
            }
        }
        System.out.println("x=" + x + ",y=" + y + ", diff = " + minDiff);
    }
}
