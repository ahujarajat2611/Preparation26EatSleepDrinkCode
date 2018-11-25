package BasicAlgorithms.Greedy;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by hadoop on 25/12/17.
 */
public class MinMoves {
    public class Solution {
        public int findMinMoves(int[] machines) {
            int n=machines.length, sum[]=new int[n+1];
            for (int i=1;i<=n;i++) sum[i]=sum[i-1]+machines[i-1];
            if (sum[n]%n!=0) return -1;
            int need=sum[n]/n, ans=0;
            for (int i=0;i<n;i++) {
                int l=i*need-sum[i], r=(n-1-i)*need-(sum[n]-sum[i+1]);
                ans=Math.max(ans, l>0&&r>0?l+r:Math.max(Math.abs(l), Math.abs(r)));
            }
            return ans;
        }
    }
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length <= 0) return 0;
        int sum = IntStream.of(machines).sum();
        if (sum % machines.length != 0) return -1;
        int per = sum / machines.length, ans = 0;
        for (int i = 0, prefixSum = 0; i < machines.length; i++) {
            int toLeft = i * per - prefixSum;
            int toRight = (machines.length - i - 1) * per - (sum - prefixSum - machines[i]);
            ans = Math.max(ans, Math.max(toLeft, 0) + Math.max(toRight, 0));
            prefixSum += machines[i];
        }
        return ans;
    }
    public int findMinMovesMy(int[] machines) {
        int n = machines.length, sum = 0;
        for(int i = 0; i < n; i++) sum += machines[i];

        if (sum % n != 0) return -1;
        int t = sum / n, d = 0, max = 0;
        for(int i = 0; i < n; i++) {
            int diff = (machines[i] - t); // dress surplus or deficit
            d += diff; // total surplus or deficit so far between index 0 .. i
            // or how many dresses needs to move between 0..i and i..(n-1)
            max = Math.max(max, Math.abs(d)); // max point with maximum number of movement needed so far
            max = Math.max(max, diff);
            //if (diff > 0) max = Math.Max(max, diff); // surplus machines cant give away more than one at a time
        }

        return max;
    }
    /*
    https://discuss.leetcode.com/topic/79923/c-16ms-o-n-solution-with-trivial-proof/3
     */
    /*
    Scan from left to right, at each point count how many net number of dresses needs to move through that point (could be a positive value if surplus on left side, or negative if surplus on right side). Point with maximum absolute value will decide how many total movements needed. However machines with surplus dresses can only give away one dress at a time, even though machines can receive multiple dresses at same time (one from left, another from right). Because of this constraint, machine with highest surplus would also become another bottleneck.

public int FindMinMoves(int[] machines) {
        int n = machines.Length, sum = 0;
        for(int i = 0; i < n; i++) sum += machines[i];

        if (sum % n != 0) return -1;
        int t = sum / n, d = 0, max = 0;
        for(int i = 0; i < n; i++) {
            int diff = (machines[i] - t); // dress surplus or deficit
            d += diff; // total surplus or deficit so far between index 0 .. i or how many dresses needs to move between 0..i and i..(n-1)
            max = Math.Max(max, Math.Abs(d)); // max point with maximum number of movement needed so far
            if (diff > 0) max = Math.Max(max, diff); // surplus machines cant give away more than one at a time
        }

        return max;
    }
     */
}
