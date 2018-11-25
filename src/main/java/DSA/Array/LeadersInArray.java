package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class LeadersInArray {
    void leadersInArray(int a[], int n) {
        if (n <= 0)
            return;
        if (n == 1) {
            System.out.println(a[0]);
            return;
        }

        int maxFromRight = a[n - 1];
        System.out.print(a[n - 1] + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > maxFromRight) {
                maxFromRight = a[i];
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }
}
