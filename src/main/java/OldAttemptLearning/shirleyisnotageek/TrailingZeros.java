package OldAttemptLearning.shirleyisnotageek;

public class TrailingZeros {
    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        int zeros = 0;
        int five = 5;
        while (n >= five) {
            zeros += n / five;
            five *= 5;
        }
        return zeros;
    }
}
/*
The number of trailing zeros in the decimal representation of n!, the factorial of a non-negative integer n, is simply the multiplicity of the prime factor 5 in n!. This can be determined with this special case of de Polignac's formula:[1]
f(n) = \sum_{i=1}^k \left \lfloor \frac{n}{5^i} \right \rfloor =
\left \lfloor \frac{n}{5} \right \rfloor + \left \lfloor \frac{n}{5^2} \right \rfloor + \left \lfloor \frac{n}{5^3} \right \rfloor + \cdots + \left \lfloor \frac{n}{5^k} \right \rfloor, \,
where k must be chosen such that
5^{k+1} > n,\,
and \lfloor a \rfloor denotes the floor function applied to a. For n = 0, 1, 2, ... this is
0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 6, ... (sequence A027868 in OEIS).
For example, 53 > 32, and therefore 32! = 263130836933693530167218012160000000 ends in
\left \lfloor \frac{32}{5} \right \rfloor + \left \lfloor \frac{32}{5^2} \right \rfloor = 6 + 1 = 7\,
zeros. If n < 5, the inequality is satisfied by k = 0; in that case the sum is empty, giving the answer 0.
The formula actually counts the number of factors 5 in n!, but since there are at least as many factors 2, this is equivalent to the number of factors 10, each of which gives one more trailing zero.
 */