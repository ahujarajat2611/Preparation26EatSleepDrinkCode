package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class ReplaceWithMaxOnRIght {
    public void replaceWithMaxOnRight(int[] a, int n) {
        if (n <= 0)
            return;
        int maxFromRight = a[n - 1];
        a[n - 1] = -1;
        int temp;
        for (int i = n - 2; i >= 0; i--) {
            temp = maxFromRight;
            maxFromRight = Math.max(a[i], maxFromRight);
            a[i] = temp;
        }
    }
}
