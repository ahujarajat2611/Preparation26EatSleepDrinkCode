package smallmomentsmakeitbigger26;
import java.util.*;

/**
 * Created by hadoop on 14/12/17.
 */

// how many such quadruples that has zero sum !!!!
    // how to find number of quadraples whose sum is zero !!!!
public class sum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;

        // prepare hashmap of two arrays
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                /// keep track of frquence since we need
                // to calculate numberof quarruples
                // very imp
                map.put(sum, map.containsKey(sum) ? map.get(sum) + 1: 1);
            }
        }

        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                int sum = A[i] + B[j];
                if (map.containsKey(-sum))
                    count += map.get(-sum);
            }
        }
        return count;
    }
}
