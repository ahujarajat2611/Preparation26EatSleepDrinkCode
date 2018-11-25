package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 23/2/18.
 */

import java.util.*;
public class FactorCombinationsOptimized {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList();
        if(n <= 1) return res;
        Set<List<Integer>> set = new HashSet();
        Helper(set, new ArrayList(), n);
        res.addAll(set);
        return res;
    }

    private void Helper(Set<List<Integer>> res, List<Integer> comb, int n){

        if(n == 1){
            res.add(comb);
        }else{
            int sqrt = (int)Math.sqrt(n);
            for(int i = 2; i <= sqrt ; i++){
                if(n % i == 0){
                    List <Integer> tmp = new ArrayList(comb);
                    tmp.add(i);
                    Helper(res, tmp, n / i);
                    tmp.add(n / i);
                    Collections.sort(tmp);
                    res.add(tmp);
                }
            }
        }
    }
}
