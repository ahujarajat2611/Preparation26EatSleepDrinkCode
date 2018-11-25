package OldAttemptLearning.dynamicprogramming;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 3/8/17.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int [] array = {-2,1,-3,4,-1,2,1,-5,4};
        AtomicInteger integer = new AtomicInteger();
        integer.set(Integer.MIN_VALUE);
        int maxsubarray = maxsubrecursive(array,array.length-1,integer);
        System.out.println(integer.get());
    }

    private static int maxsubrecursive(int[] array, int i, AtomicInteger integer) {
        if(i==0 ){
            return Math.max(0,array[0]);
        }
        else{
            integer.set(Math.max(integer.get(),Math.max(0,array[i]+maxsubrecursive(array,i-1, integer))));
            return Math.max(0,array[i]+maxsubrecursive(array,i-1, integer));
        }
    }
}
