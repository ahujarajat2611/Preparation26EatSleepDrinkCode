package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class MaxIndexDiff {
    // Time : O(n), Space : O(n)
    public int maxIndexDiff(int a[], int n) {
        int maxIndexDiff = Integer.MIN_VALUE;

        if (n <= 0)
            return maxIndexDiff;
        int leftMin[] = new int[n];
        int rightMax[] = new int[n];

        leftMin[0] = a[0];
        rightMax[n - 1] = a[n - 1];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], a[i]);
        }
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (leftMin[i] < rightMax[j]) {
                maxIndexDiff = Math.max(j - i, maxIndexDiff);
                j++;
            } else {
                i++;
            }
        }
        return maxIndexDiff;
    }
}
