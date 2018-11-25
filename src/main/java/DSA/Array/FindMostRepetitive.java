package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
// solution is wrong but idea is correct !!
public class FindMostRepetitive {
    // Find number repeated more times in range 0 to k-1; k<=n
    // Time : O(n)
    public void findAllNumbersRepeatingMoreTimes(int a[], int n, int k) {
        for (int i = 0; i < n; i++) {
            a[a[i] % k] += k;
        }
        for (int i = 0; i < n; i++) {
            a[i] = a[i] / k;
        }
        int maxRepeated = 0;
        for (int i = 0; i < n; i++) {
            maxRepeated = Math.max(maxRepeated, a[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
    }
}
