package BasicAlgorithms.String;

/**
 * Created by hadoop on 27/2/18.
 */
import java.util.*;
public class Reflection {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for(int[] p:points){
            max = Math.max(max,p[0]);
            min = Math.min(min,p[0]);
            String str = p[0] + "a" + p[1];
            set.add(str);
        }
        /*
        SUm = a + b
        to check for b check (sum-a)
         if(sum-a) exists it means b exists (offcourse you need to take care of y coordintae as well )

         */
        int sum = max+min;
        for(int[] p:points){
            //int[] arr = {sum-p[0],p[1]};
            String str = (sum-p[0]) + "a" + p[1];
            if( !set.contains(str))
                return false;

        }
        return true;
    }
}
