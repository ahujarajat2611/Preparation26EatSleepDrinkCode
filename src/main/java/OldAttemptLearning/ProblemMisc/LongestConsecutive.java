package OldAttemptLearning.ProblemMisc;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hadoop on 31/8/17.
 */
public class LongestConsecutive {
    public static void main(String args[]){
        int num[]={100,4,200,1,3,2};
        int ans = longestConsesutive(num);
        System.out.println("ans"+ans);
    }

    private static int longestConsesutive(int[] num) {
        if( num == null || num.length == 0){
            return 0;
        }
        Set<Integer> hashset = new HashSet<>();
        for( int i:num){
            hashset.add(i);
        }
        int lcs=0;
        for( int i:num){
            int n = i;
            int count = 1;
            while(hashset.contains(n-1)){
                count = count+1;
                System.out.println("n"+(n-1));
                System.out.println("count"+count);
                hashset.remove(n-1);
                n = n-1;
            }
            n = i;
            while (hashset.contains(n+1)){
                count = count+1;
                hashset.remove(n+1);
                n = n+1;
            }
            lcs = Math.max(count,lcs);
        }
        return lcs;
    }
}
