package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class MaxProductSubarray {
    public int maxProductSubArray(int a[], int n) {
        if (n <= 0) {
            return Integer.MIN_VALUE;
        }

        int maxProduct, maxEndingHere, minEndingHere;
        maxProduct = maxEndingHere = minEndingHere = a[0];
        int tempMax, tempMin;
        for (int i = 1; i < n; i++) {
            tempMax = maxEndingHere;
            tempMin = minEndingHere;
            maxEndingHere = Math.max(a[i], Math.max(a[i] * tempMax, a[i] * tempMin));
            minEndingHere = Math.min(a[i], Math.min(a[i] * tempMax, a[i] * tempMin));
            maxProduct = Math.max(maxEndingHere, maxProduct);
        }
        return maxProduct;
    }
}
