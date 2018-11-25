package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class RemoveDuplicatesArrayUnSOrted {
    public int removeDuplicatesInArray(int a[], int n) {
        int key, removed;
        for (int i = 0; i < n; i++) {
            key = a[i];
            removed = 0;
            for (int j = i + 1, k = i + 1; j < n; j++) {
                if (a[j] == key) {
                    removed++;
                } else {
                    a[k++] = a[j];
                }
            }
            n = n - removed;
        }
        return n;
    }
}
