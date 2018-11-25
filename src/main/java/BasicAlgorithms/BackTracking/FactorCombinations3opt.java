package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 25/2/18.
 */
import java.util.*;
public class FactorCombinations3opt {
    private List<List<Integer>> result;
    public List<List<Integer>> getFactors(int n) {
        result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        dfs(new ArrayList<>(), n, 2);
        return result;
    }

    private void dfs(List<Integer> path, int n, int start) {
        if (n == 1) {
            if (path.size() > 1) {
                System.out.println(path);
                result.add(new ArrayList<>(path));
            }
            return;
        }
        int maxFactor = Math.max(2, (int)Math.sqrt(n));
        for (int factor = start; factor <= n; factor++) {
            if (n % factor == 0) {
                System.out.println("com "+factor);
                path.add(factor);
                dfs(path, n / factor, factor);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinations3opt factorCombinations3opt = new FactorCombinations3opt();
        factorCombinations3opt.getFactors(20);
    }
}
