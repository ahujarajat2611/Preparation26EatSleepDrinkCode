package DSA.Array;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 11/2/18.
 */
public class RepeatingNumbers {
    public void findTwoRepeatingNumbers(int[] a, int n) {

        ConsoleWriter.printIntArray(a);
        for (int i = 0; i < n; i++) {
            int index = (a[i]-1)%n;
            a[index]+=n;
            //	a[(a[i] - 1) % n] += n;
        }
        ConsoleWriter.printIntArray(a);
        for (int i = 0; i < n; i++) {
            if (a[i] / n > 1) {
                System.out.println("Repeated : " + (i + 1));
            }
        }
    }
}
