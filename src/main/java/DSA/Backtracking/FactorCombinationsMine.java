package DSA.Backtracking;

/**
 * Created by hadoop on 22/10/17.
 */
import java.util.*;
public class FactorCombinationsMine {
    public List<List<Integer>> getFactors(int n) {
        List<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        getFactorsHelper(2,n,path,result);
        return result;
    }

    private void getFactorsHelper(int startFactor, int remainingN, List<Integer> path, List<List<Integer>> result) {
        if(remainingN == 1){
            if(path.size()>1) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=startFactor;i<=remainingN;i++){
            if(remainingN%i ==0){
                path.add(i);
               // System.out.println(n/i);
                getFactorsHelper(i,remainingN/i,path,result);
                path.remove(path.size()-1);
               // path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinationsMine factorCombinations = new FactorCombinationsMine();
        System.out.println(factorCombinations.getFactors(3));
        System.out.println(factorCombinations.getFactors(12));
        System.out.println(factorCombinations.getFactors(36));

    }
}