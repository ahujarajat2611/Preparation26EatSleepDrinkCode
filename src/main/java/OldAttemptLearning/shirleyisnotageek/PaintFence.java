package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        return (numWays(n - 2, k) + numWays(n - 1, k)) * (k - 1);
    }
}

/*
This is not a hard question. The problem is, I really am not good at combinations...

The first fence has k way. The second fence can be the same as the first one or different from the first one. If it's the same, then no more ways. If not, there can be other (k - 1) ways. So total for the second one is k + k * (k - 1) = k  * k. From the third one, its either different from the previous one or from the second previous one. So ways[i] = (k - 1) * (ways[i - 1] + ways[i - 2]).

 */