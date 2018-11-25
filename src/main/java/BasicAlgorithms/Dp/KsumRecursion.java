package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 26/10/17.
 */
import java.util.*;
public class KsumRecursion {
    private int dfsCache(int A[], int k, int target) {
        int[][][] cache = new int[k+1][A.length][target+1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < A.length; j++)
                Arrays.fill(cache[i][j], -1);
        }
        return dfsCache(A, 0, k, target, cache);
    }

    private int dfsCache(int A[], int pos, int k, int target, int[][][] cache) {
        if (target == 0 && k == 0)
            return 1;
        if (target < 0 || k <= 0 || pos+k > A.length)
            return 0;
        if (cache[k][pos][target] != -1)
            return cache[k][pos][target];
        int nWay = dfsCache(A, pos+1, k, target, cache);
        nWay += dfsCache(A, pos+1, k-1, target - A[pos], cache);
        cache[k][pos][target] = nWay;
        return nWay;
    }
}
