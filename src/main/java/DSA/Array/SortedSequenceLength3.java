package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class SortedSequenceLength3 {
    public void findSortedSequenceOfLength3(int[] a, int n) {

        if (n < 3)
            return;

        int smaller[] = new int[n];
        int larger[] = new int[n];
        int min = 0;
        int max = n - 1;

        smaller[0] = -1;
        larger[n - 1] = -1;

        for (int i = 1; i < n; i++) {
            if (a[i] > a[min]) {
                smaller[i] = min;
            } else {
                smaller[i] = -1;
                min = i;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[max]) {
                larger[i] = max;
            } else {
                larger[i] = -1;
                max = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && larger[i] != -1) {
                System.out.println(a[smaller[i]] + " " + a[i] + " " + a[larger[i]]);
            }
        }
    }
    public void sortedSequenceOfLength3(int[] a, int n) {
        if (n < 3)
            return;
        int smaller[] = new int[n];
        int larger[] = new int[n];
        int minIndex = 0, maxIndex = n - 1;
        smaller[0] = 0;
        larger[n - 1] = n - 1;
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[minIndex]) {
                smaller[i] = i;
                minIndex = i;
            } else {
                smaller[i] = minIndex;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] >= a[maxIndex]) {
                larger[i] = i;
                maxIndex = i;
            } else {
                larger[i] = maxIndex;
            }
        }
        for (int i = 0; i < n; i++) {
            if (smaller[i] != i && larger[i] != i) {
                System.out.println(a[smaller[i]] + " " + a[i] + " " + a[larger[i]]);
            }
        }
    }
}
