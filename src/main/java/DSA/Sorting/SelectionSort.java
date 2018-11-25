package DSA.Sorting;

/**
 * Created by hadoop on 13/2/18.
 */
public class SelectionSort {
    public void selectionSort(int[] a, int n) {
        int min_index = -1, temp;
        for (int i = 0; i < n; i++) {
            min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min_index] > a[j]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                temp = a[min_index];
                a[min_index] = a[i];
                a[i] = temp;
            }
        }
    }
}
