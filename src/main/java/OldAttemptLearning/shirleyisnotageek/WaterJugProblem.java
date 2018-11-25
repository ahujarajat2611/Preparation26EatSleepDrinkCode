package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
/*
Water and Jug Problem
You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
Operations allowed:
Fill any of the jugs completely with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
Example 1: (From the famous "Die Hard" example)
Input: x = 3, y = 5, z = 4
Output: True
Example 2:
Input: x = 2, y = 6, z = 5
Output: False

Another math problem. The idea is to find a number z such that
 z = m * x + n * y, where m, n can be any integer.
  In the Die hard example,
  4 = 3 * (-2) + 5 * 2.
  According to Bézout's identity,
  z must be a multiple of
   x and y's greatest common divisor.
    Now the rest of the problem is
    to find GCD of x and y.
     Note z must be less than x + y
     because x and y cannot represent any
     number that is larger than the
     sum of their capacity.

 */
public class WaterJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        int gcd = gcd(x, y);
        if (gcd == 0)
            return z == 0;
        return z <= x + y && z % gcd == 0;
    }

    private int gcd(int x, int y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
    }
}
