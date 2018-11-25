package DSA.Array;

import java.util.Arrays;

/**
 * Created by hadoop on 10/2/18.
 */
public class CheckPairsWithSum {
    void checkForPairsWithSum(int a[], int n, int sum) {
        Arrays.sort(a);
        int l = 0, r = n - 1, t;
        while (l < r) {
            t = a[l] + a[r];
            if (t == sum) {
                System.out.println(a[l] + "," + a[r]);
            } else if (sum > t) {
                l++;
            } else {
                r--;
            }
        }
    }
    void checkForPairWithSumK(int a[], int n, int k) {
        boolean map[] = new boolean[100000];
        // instead of map can use hashmap
        int temp;
        for (int i = 0; i < n; i++) {
            temp = k - a[i];
            if (temp >= 0 && map[temp] == true) {
                System.out.println("1st=" + a[i] + ",2nd=" + temp);
            }
            map[a[i]] = true;
        }
    }
}
