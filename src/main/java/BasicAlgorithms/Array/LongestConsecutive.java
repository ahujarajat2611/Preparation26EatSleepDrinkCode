package BasicAlgorithms.Array;
import java.util.*;

/**
 * Created by hadoop on 19/12/17.
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if( nums == null || nums.length == 0){
            return 0;
        }
//         Set<Integer> hashset = new HashSet<>();
//         for( int i:nums){
//             hashset.add(i);
//         }
//         int lcs=0;
//         for( int i:nums){
//             int n = i;
//             int count = 1;
//             while(hashset.contains(n-1)){
//                 count = count+1;
//                 hashset.remove(n-1);
//                 n = n-1;

//             }
//             n = i;
//             while (hashset.contains(n+1)){
//                 count = count+1;
//                 hashset.remove(n+1);
//                 n = n+1;
//             }
//             lcs = Math.max(count,lcs);
//         }
//         return lcs;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
            // addd all ements to set
        }
        // Iterator<Integer> it = set.iterator();
        int maxsize = 0;
        while(!set.isEmpty()) {
            // everytime picking one element from set whichever not considered
            Iterator<Integer> it = set.iterator();
            int elem = it.next();
            if (set.remove(elem)) {
                int leftsize = 0;
                int rightsize = 0;
                int leftreduce = elem - 1;
                int rightreduce = elem + 1;
                // i cant use iterator to remove
                // using iterator to fetch element in the set and thatts it post that
                //using remove method of set to remove //

                //ietator has only remove () method and set has set.remove(elem) method
                // once you create
                while (set.remove(leftreduce)) {
                    leftreduce--;
                    leftsize++;
                }
                while (set.remove(rightreduce)) {
                    rightreduce++;
                    rightsize++;
                }
                maxsize = Math.max(maxsize, leftsize + rightsize + 1);
            }
            // you have create ietaror but but but removeing using set method why it is workin
            // since you are using only method once .. post that you crea creating new ietaroe
            // any operation like itertor.next() once you remove ffrom set will give concurrent
            // modification error
        }
        return maxsize;
    }
}
