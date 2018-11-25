package BasicAlgorithms.Math;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by hadoop on 3/1/18.
 */
public class ShuffleArray {
    void shuffleArray(int a[], int n)
    {
        // Rotate the element to the left
        for (int i = 0, q = 1, k = n; i < n; i++, k++, q++)
            for (int j = k; j > i + q; j--)
                swap(a,j-1, j);
    }
    protected void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void shuffle2(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));   // between i and n-1
            int r1 = i + new Random().nextInt(n-i);
            swap(a, i, r1);
        }
    }

}
class Solution {

    int[] orig;
    int[] curr;
    int len;
    final Random random;

    public Solution(int[] num) {
        len = num.length;
        orig = num;
        curr = Arrays.copyOf(num, len);
        random = new Random();
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.curr = Arrays.copyOf(orig, orig.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < len - 1; i++) {
            int pos = getPos(i, len);
            swap(curr, i, pos);
        }
        return curr;
    }

    private int getPos(int start, int end) {
        return random.nextInt(end - start) + start;
    }

    private void swap(int[] num, int first, int second) {
        int tmp = num[first];
        num[first] = num[second];
        num[second] = tmp;
    }

    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8,9};
        ShuffleArray array = new ShuffleArray();
        array.shuffle2(arr);
        ConsoleWriter.printArray(arr);
//        for(int i=0;i<10;i++) {
//            System.out.println(Math.random() * 5);
//            System.out.println(5 + new Random().nextInt(5));
//            //new Random().nextInt();
//
//        }
    }
}
