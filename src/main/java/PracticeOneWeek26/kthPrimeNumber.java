package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 10/12/17.
 */
public class kthPrimeNumber {
    public long kthPrimeNumber(int k) {

        PriorityQueue<Long> queue = new PriorityQueue<Long>();

        queue.add((long)3);
        queue.add((long)5);
        queue.add((long)7);

        long num = 0;
        for(int i=0;i<k;i++){
            num = queue.poll();
            if(num%3 ==0){
                queue.add((long)num*3);
            }
            if(num%5 ==0){
                queue.add((long)num*3);
                queue.add((long)num*5);
            }
            if(num % 7 == 0){
                queue.add((long)num*3);
                queue.add((long)num*5);
                queue.add((long)num*7);
            }
        }
        return num;
    }
}