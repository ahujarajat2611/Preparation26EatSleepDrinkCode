package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class ReplaceLeftRightMultiply {
    public void replaceWithLeftRightMultiplication(int a[], int n) {
        if (n <= 1)
            return;
        int cur, prev;
        prev = a[0];
        a[0] = a[0] * a[1];

        for (int i = 1; i < n - 1; i++) {
            cur = a[i];
            a[i] = prev * a[i + 1];
            prev = cur;
        }
        a[n - 1] = a[n - 1] * prev;
    }
}
