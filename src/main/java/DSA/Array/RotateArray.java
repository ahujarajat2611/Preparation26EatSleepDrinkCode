package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class RotateArray {
    void reverse(int a[], int l, int r) {
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    void rotateArray(int a[], int n, int d) {
        reverse(a, 0, d - 1);
        reverse(a, d, n - 1);
        reverse(a, 0, n - 1);
    }
}
