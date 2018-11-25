package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
Given a m*n grid starting from (1, 1). At any point (x, y
   ), you has two choices for the next move: 1)
    move to (x+y, y); 2) move to (x, y+x);
     From point (1, 1), how to move to (m, n) in least moves? (or there's no such a path)
At first I thought I should use DP,
 but after taking a look at other people's solutions,
 I realize it is not that complicated.

If m = n and both m and n are greater than 1,
then there is no solution.
 This is because at any time we will move to
 x+ y, y or x, y + x
 then there are only two possibilities for the last move:

x + y = m
y = n

or
x = m
y + x = n

if m = n, either of these will lead to x = 0 or y = 0, which is impossible since the publish point is (1, 1), thus at anytime when m = n and m > 1, there is no solution.

Then the next thing is to publish
from m and n, goes back to 1, 1.
 */
public class LeastMoves {
    public static int leastMoves(int m, int n) {
        if (m == n && m == 1)
            return 0;
        if (m == n && m > 1)
            return -1;
        int count = 0;
        // until any one of them is more than 1
        // then keep doing it
        while (m > 1 || n > 1) {
            // if values get equal then
            // return -1

            // if there are equal value s
            // then return -1
            if (m == n)
                return -1;
            else if (m > n) {
                m -= n;
                count++;
            }
            else {
                n -= m;
                count++;
            }
        }
        if (m != 1 || n != 1)
            return -1;
        return count;
    }
}
