package AwangDevLintCode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by hadoop on 24/2/18.
 */



/*


EXCAT SUBARRAY INDEXES -> HASHMAP
CLOSES SUBARRAY INDEXEX-> TREEMAP
 */
/*

If we need to find exact sum subarrayy then we should use HashMpa
but when it comes to nearest kind of problem , bells should ring in your mind it has to get solved by treeset

HERE WE NEED FIND SUBARRAY SUM CLOSEST TO PARTICULAR SUM SO BETTER WE SHOULD LOOK FOR TREESET ( TREEMAP IF WE NEEDD INDEXXES AS WELL
)

*/
public class SubarraySumClosestToK {
    // since we need to find closes to zero
    // we dont have to find actuall subarray so wee can choose to ingore preparing pair so keep track of indexes
    // of that subarray !!!

    public static double closestToZero(double[] x){
        // COULD HAVE USED TREE SET
        // FOR SUBARRAY INDEXES, WE CULD HAVE USEDD TREEMAP TO TRACK OF INDEXES


        double[] cumulative = new double[x.length];
        cumulative[0] = x[0];
        for(int i = 1; i < x.length; i++){
            cumulative[i] = cumulative[i-1] + x[i];
        }
        Arrays.sort(cumulative);
        double mindiff = Double.MAX_VALUE;
        for(int i = 0; i < cumulative.length-1; i++){

            mindiff = Math.min(mindiff,cumulative[i+1] - cumulative[i]);
        }
        return mindiff;
    }
    public static double closestToT(double[] x, double t){
        double prefix = 0;
        TreeSet<Double> set = new TreeSet<Double>();
        set.add(prefix);
        double leastDiff = Double.MAX_VALUE;

        for(double i : x){
            prefix += i; // the cumulative sum up to i

            double rest = prefix - t; // how far away we are from t
            if(set.first() <= rest){
                // check for nearest element prefix-t and prefix +t
                // we can deal with such things
                double theSum = prefix - set.floor(rest);
                leastDiff = Math.min(leastDiff, Math.abs(theSum - t));
            }

            if(set.last() >= rest){
                double theSum = prefix - set.ceiling(rest);
                leastDiff = Math.min(leastDiff, Math.abs(theSum - t));
            }
            set.add(prefix);
        }
        return leastDiff;
    }
}
