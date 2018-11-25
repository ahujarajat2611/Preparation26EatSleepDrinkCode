package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class ReverseInteger {
    public int reverseInteger(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + (n % 10);
            n = n / 10;
        }
        return rev;
    }
}
