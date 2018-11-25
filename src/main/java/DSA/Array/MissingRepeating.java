package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class MissingRepeating {
    public void findMissingAndRepeating(int a[], int n) {
        int j;

        for (int i = 0; i < n; i++) {
            j = Math.abs(a[i]) - 1;
            if (a[j] < 0) {
                System.out.println("Repeating : " + (j + 1));
            } else {
                a[j] = -a[j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                System.out.println("Missing : " + (i + 1));
                return;
            }
        }
    }
}
