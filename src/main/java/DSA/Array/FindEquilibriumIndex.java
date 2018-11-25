package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class FindEquilibriumIndex {
    public void findEqulibriumIndexWithoutExtraSpace(int[] a, int n) {
        int sum = 0;
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        for (int i = 0; i < n; i++) {
            sum -= a[i];
            if (leftSum == sum) {
                System.out.println("Equlibrium Index : " + i);
            }
            leftSum += a[i];
        }
    }
}
