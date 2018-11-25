package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
This is a very interesting problem. Basically, initialize sum = a[0],  from the second element in the rst array, let rst[i] = sum, then sum += a[i]. Note that initialize rst[0] = 1 for product. Then reset sum to a[a.length - 1]. From the second last element, let rst += sum, sum += a[i].

The initiative is the first loop will add(multiply) all elements from 0 to i - 1, and the second loop will add (multiply) all elements from i + 1 to a.length - 1.
  You are given an array of integers 'a' that can fit in a memory. Write a method that returns an array of the same length such that each element 'i' of this array is a sum(product) of 'a' except the element a[i]. You are not allowed to use '-' ('/') operator.

 */
public class SubtractionAndProduct {
    public static int[] arraySum(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Null or Empty array!");
        int sum = array[0];
        int[] rst = new int[array.length];
        for (int i = 1; i < rst.length; i++) {
            rst[i] = sum;
            sum += array[i];
        }
        sum = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            rst[i] += sum;
            sum += array[i];
        }
        return rst;

    }
    public static int[] product(int[] A){
        if (A == null || A.length == 0)
            return A;
        int rst[] = new int[A.length];
        rst[0] = 1;
        //Arrays.fill(rst, 1);
        int product = A[0];
        for (int i = 1; i < A.length; i++){
            rst[i] = product;
            product *= A[i];
        }

        product = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--){
            rst[i] *= product;
            product *= A[i];
        }
        return rst;
    }

}
