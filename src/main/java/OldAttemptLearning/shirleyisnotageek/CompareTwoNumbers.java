package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
public class CompareTwoNumbers {
    public static int getMax(int a, int b){
        int c = a - b;
        //the 32nd bit is 1 if the number is negative, 0 if positive
        int k = (c >> 31) & 1;
        int max = a - k * c;
        return max;
    }

    // take diff ( a-b)
    // c = a-b >> 31 &1
    // if this bit is one then a >0;
    // a + c(a-b)
    // if c is one then ans a
    /*

This is such an easy problem except you cannot use anything you can think of.
Let c = a - b, then the larger number between a and b = a + k * c where k = 0 if a is the larger one and k = 1 if b is the larger one. Now we need some help from the bits. If a number is negative, we know the 32nd bit of the number is 1, otherwise, it is 0. So the problem becomes find the most significant bit k of c = a - b and return max = a + k*c
     */
}
