package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
public class PaintFence {
    /*
Thoughts:
Inspiration(http://yuanhsh.iteye.com/blog/2219891)
Consider posts from 1 ~ n. Now we look at last post, marked n:
S(n) means: last 2 fence posts have same color.
	Note: S(n) will equal to whatever that's on n-1 position.
	Also, just because n and n-1 are same, that means n-2 and n-1 have to be differnet.
SO:
S(n) = D(n - 1)
D(n) means: last 2 fence posts have different color.
	Note: for n - 1, and n-2 positions, we have 2 different conditions:
	For example: xxy, or wxy, same 2 x's or different w vs. x.
So:
D(n) = (k - 1) * (D(n - 1) + S(n - 1))

We can also create T(n) = S(n) + D(n); //T(n) is our totoal results. Will need to return T(n);
Use above equations to figure out T(n)
T(n) = S(n) + D(n) =

D(n - 1) + (k - 1) * (D(n - 1) + S(n - 1))
	= D(n - 1) + (k - 1)(T(n - 1))
	= (k - 1) * (D(n - 2) + S(n - 2)) + (k - 1)(T(n - 1))
	= (k - 1)(T(n - 1) + T(n - 2))
	Since n-2 >=1, so n>=3. We need fiture out cases for n = 0,1,2,3

Note:
n == 1: just k ways
n == 0: just 0.
k == 0: just 0;
Besides these cases, we are okay. Btw, k does not really matter as long as it's >=1, it can be plugged in.
*/
    public int numWays(int n, int k) {
        if (n <= 1 || k <= 0) {
            return n * k;
        }
        int[] dp = new int[n + 1]; //index based : 1
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k + k*(k - 1);
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
    public static int numWaytoPaintFence(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
        if (n == 1)
            return k;

        // same[i] means the ith post has the same color with the (i-1)th post.
        int[] same = new int[n];

        // diff[i] means the ith post has a diff color with the (i-1)th post.
        int[] diff = new int[n];
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; ++i) {
            // the i-th in same should be equal the previous one in diff since
            // only two consecutive same are allowed
            same[i] = diff[i - 1];
            // the i-th in diff should be either different from its previous one
            // or from the one before the previous one
            diff[i] = (k - 1) * same[i - 1] + (k - 1) * diff[i - 1];
        }
        return same[n - 1] + diff[n - 1];
    }
}
