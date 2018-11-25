package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by hadoop on 21/9/17.
 */
public class UglyNumbers {
    int [] ugly(int n){
        int []ulgly = new int[n+1];
        ulgly[1] = 2;
        int i2 = 1;
        int  i5 = 1;
        int i7 = 1;
        for (int i=2;i<=n;i++){
            ulgly[i] = Math.min(Math.min(ulgly[i2]*2,ulgly[i5]*2),ulgly[i7]*7);
            if(ulgly[i] == ulgly[i2]*2){
                i2 = i2+1;
            }
            if(ulgly[i] == ulgly[i5]*5){
                i5 = i5+1;
            }
            if(ulgly[i] == ulgly[i7]*7){
                i7 = i7+1;
            }
        }
        return ulgly;
    }
    int []uglyNUmberUsingPq(int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int []factors = {2,3,5};
        pq.add(1);
        set.add(1);
        int []ugly = new int[n+1];
        ugly[1] = 1;
        for(int i=1;i<=n;i++){
            int number = pq.poll();
            ugly[i] = number;
            for(int factor:factors){
                int numbertoinsert = factor*number;
                if(!set.contains(numbertoinsert)){
                    set.add(numbertoinsert);
                    pq.add(numbertoinsert);
                }
            }
        }
        return ugly;
    }
}
