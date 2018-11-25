package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 26/2/18.
 */
public class FactorCombinations2 {
    private List<List<Integer>> result;
    public List<List<Integer>> getFactors(int n) {
        result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        dfs(new ArrayList<>(), n, 2,n/2);
        return result;
    }

    private void dfs(List<Integer> path, int n, int start,int originaln) {
        if (n == 1) {
            System.out.println("path "+path);
            if (path.size() > 1) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        int maxFactor = Math.max(2, (int)Math.sqrt(originaln));
        for (int factor = start; factor <= n; factor++) {
            if (n % factor == 0) {
                path.add(factor);
                dfs(path, n / factor, factor,originaln);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinations2 factorCombinations2 = new FactorCombinations2();
        System.out.println(factorCombinations2.getFactors(36));
    }
}
