package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count += xor & 1;
            xor = xor >> 1;
        }
        return count;
    }
}
