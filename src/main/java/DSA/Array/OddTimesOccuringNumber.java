package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class OddTimesOccuringNumber {
    int findNumberOccuringOddNumberOfTimes(int a[], int n) {
        if (n <= 0)
            return -1;
        int x = a[0];
        for (int i = 1; i < n; i++) {
            x = x ^ a[i];
        }
        return x;
    }
}
