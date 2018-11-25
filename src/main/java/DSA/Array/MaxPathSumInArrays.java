package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class MaxPathSumInArrays {
    public int maxSumPathInTwoArrays(int a[], int m, int b[], int n) {
        int i, j;
        int sum, aSum, bSum;
        i = j = aSum = bSum = sum = 0;

        while (i < m && j < n) {
            if (a[i] < b[j]) {
                aSum += a[i++];
            } else if (a[i] > b[j]) {
                bSum += b[j++];
            } else {
                aSum += a[i++];
                bSum += b[j++];
                sum += aSum > bSum ? aSum : bSum;
                aSum = bSum = 0;
            }
        }

        while (i < m) {
            aSum += a[i++];
        }

        while (j < n) {
            bSum += b[j++];
        }
        sum += aSum > bSum ? aSum : bSum;

        return sum;
    }
}
