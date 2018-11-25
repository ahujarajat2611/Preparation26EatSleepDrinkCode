package DSA.Array;

import java.util.Arrays;

/**
 * Created by hadoop on 10/2/18.
 */
public class CountPythaGoresTriplet {
    public int coutnPythogareanTripletsMethod2(int a[], int n) {
        for (int i = 0; i < n; i++) {
            a[i] = a[i] * a[i];
        }
        Arrays.sort(a);
        int l, r, sum;
        int count = 0;
        for (int i = n - 1; i >= 2; i--) {
            l = 0;
            r = i - 1;
            while (l < r) {
                sum = a[l] + a[r];
                if (sum > a[i]) {
                    r--;
                } else if (sum < a[i]) {
                    l++;
                } else {
                    count++;
                    l++;
                    r--;
                }
            }
        }
        return count;
    }
}
