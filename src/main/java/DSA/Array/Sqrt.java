package DSA.Array;

/**
 * Created by hadoop on 22/2/18.
 */
public class Sqrt {
    public double sqrt(int n) {
        double g = 1.0;
        while (Math.abs(g * g - n) > 0.0000000001) {
            g = (g + (n / g)) / 2;
        }
        return g;
    }
}
