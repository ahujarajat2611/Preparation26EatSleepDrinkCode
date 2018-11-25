package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class SmallestSecondSmallestAgain {
    public void findSmallestandSecondSmallestInSingleTraversal(int a[], int n) {
        int min1, min2;
        min1 = min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < min1) {
                min2 = min1;
                min1 = a[i];
                // Very imp case to
            } else if (a[i] < min2 && a[i] != min1) {
                min2 = a[i];
            }
        }
    }
}
