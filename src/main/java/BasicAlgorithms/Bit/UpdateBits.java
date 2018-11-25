package BasicAlgorithms.Bit;

/**
 * Created by hadoop on 19/12/17.
 */
public class UpdateBits {
    public int updateBits(int n, int m, int i, int j) {
        int high = (j < 31) ? (~((1 << (j + 1)) - 1)) : 0;
        int low = (1 << (i)) - 1;
        int mask = high | low;

        return (n & mask | (m << i));
    }
    int updateBitsAgain(int n, int m, int i, int j) {
        int ones = ~0;
        int left = ones << (j + 1);
        int right = ((1 << i) - 1);
        int mask = left | right;

        return (n & mask) | (m << i);// (Only i left shift is necessary thats okay
        // ;
    }
}
