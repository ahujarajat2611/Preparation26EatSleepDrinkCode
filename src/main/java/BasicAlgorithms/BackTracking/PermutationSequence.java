package BasicAlgorithms.BackTracking;
import java.util.*;

/**
 * Created by hadoop on 7/1/18.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++){
            list.add(i);
        }
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++){
            factorial[i] = factorial[i - 1] * i;
        }
        k--; // the k th permutation's index is k - 1
        // if size if n
        // loop for n vluaes simple !!!!
        for (int i = n - 1; i >= 0; i--){
            int index = k / factorial[i];
            sb.append(String.valueOf(list.remove(index)));
            k -= index * factorial[i];
        }
        return sb.toString();
    }
}
