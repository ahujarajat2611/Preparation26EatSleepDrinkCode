package BasicAlgorithms.Math;

/**
 * Created by hadoop on 2/3/18.
 */
public class DivideMineSimplest {
    int divideMine(int dividend, int divisor) {
        int ans = 0;

        while (divisor <= dividend) {
            int temp = divisor;
            int shift = 1;
            while (temp <= dividend) {
                temp = temp << 1;
                shift = shift << 1;
            }
            temp = temp >> 1;
            shift = shift >> 1;
            dividend = dividend - temp;
            ans = ans + shift;
        }
        return ans;
    }

}
