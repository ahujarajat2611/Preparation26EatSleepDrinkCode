package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/*
Permutation
take 2 from n elements
(order matters), there are total P(2, n) = n! / (n-2)! = n * (n-1)
 possible solutions
 */

/**
 * Created by hadoop on 18/1/18.
 */
public class Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> map = new HashMap();
        int res = 0;
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i == j) continue;
                int d = distance(points[i],points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }


            for(int val : map.values()) {
                res += val * (val-1); // k * (k - 1) possibilities
            }
            map.clear();
        }
        return res;
    }


    private int distance(int[] a, int[] b){
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

}
