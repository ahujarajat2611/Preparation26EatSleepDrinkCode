package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class LargestPairSum {
    public int findLargestPairSumInArray(int a[], int n) {
        if (n < 2)
            return Integer.MIN_VALUE;
        int firstMax, secondMax;
        firstMax = a[0];
        secondMax = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            if (a[i] > firstMax) {
                secondMax = firstMax;
                firstMax = a[i];
            } else if (a[i] > secondMax) {
                secondMax = a[i];
            }
        }
        return firstMax + secondMax;
    }
}
