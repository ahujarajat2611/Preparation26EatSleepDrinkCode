package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
import java.util.*;
public class WoodCut {
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0 || k < 0) {
            return 0;
        }
        if (L.length == 1) {
            return L[0] / (L[0] / k);
        }
        Arrays.sort(L);
        int start = 0;
        int end = L[L.length - 1];
        int mid = 0;
        int max = 0;
        // int min = L[0];
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            //if (mid > min) {
            //    end = mid;
            // } else {
            int count = 0;
            for (int i : L) {
                count += i / mid;
            }
            if (count < k) {
                end = mid;
            } else {
                start = mid;
                max = mid;
            }
            //}
        }//end while
        return max;
    }
}
