package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class WiggleSort {
    public void wiggleSort(int a[], int n) {
        // Take a note its starting from 1 and aneding at n-2
        for (int i = 1; i < n - 1; i += 2) {
            if (a[i] < a[i - 1])
                swap(a, i, i - 1);
            if (a[i] < a[i + 1])
                swap(a, i, i + 1);
        }
    }
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
