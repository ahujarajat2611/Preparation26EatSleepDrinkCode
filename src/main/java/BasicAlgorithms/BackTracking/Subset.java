package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 22/10/17.
 */
import java.util.*;
public class Subset {
    public List<List<Integer>> subsets(int[] S) {

        ArrayList<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        if (S == null || S.length == 0) {
            return result;
        }
        Arrays.sort(S);
        subsetsHelper(0, path, result, S);
        return result;
    }

    public void subsetsHelper(int start, ArrayList<Integer> path, List<List<Integer>> result, int[] S) {
            result.add(new ArrayList<>(path));
            for (int i = start; i < S.length; i++) {
            path.add(S[i]);
           // System.out.println(path);
            subsetsHelper(i + 1, path, result, S);
            path.remove(path.size() - 1);
            while (i<S.length-1 && S[i] == S[i+1]) i++;
        }
    }

    public static void main(String[] args) {
        Subset subset = new Subset();
        System.out.println(subset.subsets(new int[]{1,2,3}));
    }
}
