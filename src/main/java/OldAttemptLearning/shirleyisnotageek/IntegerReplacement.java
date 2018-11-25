package OldAttemptLearning.shirleyisnotageek;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 24/1/18.
 */
/*
The most straightforward way is to use recursion. Recursively calculate number of replacement needed until integer reaches 1.

 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        return getCount(n, 0);
    }

    private int getCount(long n, int count) {
        if (n == 1) {
            return count;
        }

        count++;
        if (n % 2 == 0) {
            return getCount(n / 2, count);
        } else {
            return Math.min(getCount(n - 1, count), getCount(n + 1, count));
        }
    }

    public static void main(String[] args) {
        IntegerReplacement ir = new IntegerReplacement();
        System.out.println(ir.integerReplacement(115));
        System.out.println(ir.intreplacementmine(115));

    }

    int intreplacementmine(int n){

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        int level =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int x = queue.poll();
                //System.out.println(x);
                if(x == 1){
                    return level;
                }
                if(x%2 == 0) {
                    queue.add(x / 2);
                }
                else {
                    queue.add(x - 1);
                    queue.add(x + 1);
                }
            }
            level++;
        }
        return -1;
    }
    // how abt using BFS
}
class Pair{
    int steps;
    int number;
    Pair(int steps,int number){
        this.steps= steps;
        this.number = number;
    }
}
