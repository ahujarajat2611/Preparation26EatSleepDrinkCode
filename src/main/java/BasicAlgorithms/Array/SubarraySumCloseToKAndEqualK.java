package BasicAlgorithms.Array;

/**
 * Created by hadoop on 25/2/18.
 */
import java.util.*;
public class SubarraySumCloseToKAndEqualK {

    // https://rafal.io/posts/subsequence-closest-to-t.html
   /*
   Let prefix[i] be the cumulative sum up to ii, like in the example above. Then, we need to compute the best subarray ending at ii. This means we need to find an index j<ij<i such that the sum is as close as possible to tt. This means that this value needs to be as close as possible to prefix[i] - t, since  prefix[i] - prefix[j] is the sum of the subsequence between [j,i]. So, for every prefix, we must find another earlier prefix that’s as close in value to prefix[i] - t. We can use a Java TreeSet for this which supports O(log(n))O(log⁡(n)) insertion, lower bound, and upper bound operations.

The working Java code:


The idea was to again sort the cumulative array, but this time keep two indices – one starting at the very left and one at the very right, and move them together until a best solution is found.
but it didnt work !



    */
    public static double closestToT(double[] x, double t){
       double prefix = 0;
       TreeSet<Double> set = new TreeSet<Double>();
       set.add(prefix);
       double leastDiff = Double.MAX_VALUE;

       for(double i : x){
           prefix += i; // the cumulative sum up to i
           double rest = prefix - t; // how far away we are from t
           if(set.first() <= rest){
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
   /*
   We can publish off with the simpler case where t=0t=0. The naive solution is to go through every pair of indices, and compute the sum in between. This is O(n3)O(n3), but can be reduced to O(n2)O(n2) if we accumulate the sum in the innermost loop.

Here is a way to do this in O(nlog(n))O(nlog⁡(n)):

Compute a cumulative sum array AcumAcum
Sort AcumAcum. The smallest difference will be between two consecutive elements. If two consecutive elements are equal in sort(AcumAcum), then there exists a subsequence that sums precisely to 00. Hence, go through all adjacent pairs, and compute the smallest difference.
    */

    public static double closestToZero(double[] x){
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
}
