package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

/**
 * Created by hadoop on 22/9/17.
 */
public class FactorCombination {
    List<List<Integer>> factorCombinations(int n){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        factorCombinationsHelper(result,path,n,2);
        return result;
    }

    private void factorCombinationsHelper(List<List<Integer>> result, List<Integer> path, int n,int start) {
        System.out.println("path "+ path+" publish "+start +" n "+n);
        if(n == 1){
            result.add(new ArrayList<>(path));
            return;
        }
        int maxfactor = Math.max(2,(int)sqrt(n));
        //System.out.println("maxfactor"+maxfactor);
        for(int factor=start;factor<=maxfactor;factor++){
          //  System.out.println("n value before "+n);
           // System.out.println("factor"+factor);
           // System.out.println("n value after"+n);
            if((n % factor) == 0){
             //   System.out.println("entering here "+"n "+n +" factor "+factor);
                n= n/factor;
                path.add(factor);
                factorCombinationsHelper(result,path,n,factor);
                n = n*factor;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombination factorCombination = new FactorCombination();
        System.out.println(factorCombination.factorCombinations(12));
    }
    private  class Solution {
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
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            int maxFactor = Math.max(2, (int)Math.sqrt(n));
            for (int factor = start; factor <= maxFactor; factor++) {
                if (n % factor == 0) {
                    path.add(factor);
                    dfs(path, n / factor, factor);
                    path.remove(path.size() - 1);
                }
            }
        }

    }
}
