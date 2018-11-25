package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
public class InterweaveArray {
    public static void swapArray(int[] array){
        if(array == null || array.length <= 1)
            return;
        for(int i = 1; i < array.length; i += 2){
            if(array[i - 1] > array[i])
                swap(array, i - 1, i);
            if(i < array.length - 1 && array[i + 1] > array[i])
                swap(array, i, i + 1);
        }
    }
    private static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
/*
Interweave array

Given an array Of integers build a new array of integers such that every 2nd element of the array is greater than its left and right element.

eg:
[1,4,5,2,3]

o/p:
[1,4,2,5,3]

Soln proposed:

Step 1:Sort The array -> O(nlogn)
Step 2:Use 2 indices: one starting at leftmost index and other at rightmost index.
and populate the new array alterntely using the left pointer(index) first and then the right pointer and then increment the pointer used. till both the pointers meet/cross each other. -> O(n).

I see this "simple" problems couple times and finally get the solution. If we break down the question, we will see that we actually need to maintain all triplets in the order of a <= b >= c.

I was stuck on the part on how to maintain the order of the triplets, in the end, I should just increment the index by 2 instead of 1.

 */
