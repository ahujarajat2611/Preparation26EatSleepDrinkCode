package DSA.Array;

import static DSA.Array.WiggleSort.swap;

/**
 * Created by hadoop on 10/2/18.
 */
public class Shuffle {
    // Time :O(n)
    public void shuffle(int a[], int n) {
        int rand;
        for (int i = n - 1; i > 0; i--) {
            rand = (int) (Math.random() * (i + 1));
            swap(a, i, rand);
        }
    }
}
