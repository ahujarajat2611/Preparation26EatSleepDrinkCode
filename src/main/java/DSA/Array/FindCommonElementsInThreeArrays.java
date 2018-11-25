package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class FindCommonElementsInThreeArrays {
    public void findCommonElementsInThreeSortedArrays(int a[], int p, int b[], int q, int c[], int r) {
        int i, j, k;
        i = j = k = 0;
        while (i < p && j < q && k < r) {
            if (a[i] == b[j] && b[j] == a[k]) {
                System.out.print(a[i]);
                i++;
                j++;
                k++;
            }
            if (a[i] < b[j])
                i++;
            else if (b[j] < c[k])
                j++;
                // We reach here when x > y and z < y, i.e., z is smallest
            else
                k++;
        }
    }
}
