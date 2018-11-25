package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 22/10/17.
 */
import java.util.*;
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        getFactorsHelper(2,n,path,result);
        return result;
    }

    private void getFactorsHelper(int start, int n, List<Integer> path, List<List<Integer>> result) {
        if(n == 1){
            if(path.size()>1) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=start;i<=n;i++){
            if(n%i ==0){
                path.add(i);
                System.out.println(n/i);
                getFactorsHelper(i,n/i,path,result);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinations factorCombinations = new FactorCombinations();
        System.out.println(factorCombinations.getFactors(12));
    }
}