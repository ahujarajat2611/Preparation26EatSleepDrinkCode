/**
 *
 */
package DSA.Dp;

import java.util.stream.IntStream;

import static java.lang.Integer.MIN_VALUE;

/**
 * @author Raj
 * 
 * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.

For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time .

Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.

Example1

Input: [1,0,5]

Output: 3

Explanation: 
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3    
3rd move:    2     1 <-- 3    =>    2     2     2   
Example2

Input: [0,3,0]

Output: 2

Explanation: 
1st move:    0 <-- 3     0    =>    1     2     0    
2nd move:    1     2 --> 0    =>    1     1     1     
Example3

Input: [0,2,0]

Output: -1

Explanation: 
It's impossible to make all the three washing machines have the same number of dresses. 
Note:
The range of n is [1, 10000].
The range of dresses number in a super washing machine is [0, 1e5].
 */
public class SuperWashingMachines {

    // Time : O(n), Space : O(1)
    // https://discuss.leetcode.com/topic/79938/super-short-easy-java-o-n-solution
    public int findMinMoves(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if (sum % a.length != 0) {
            return -1;
        }

        int target = sum / a.length;
        int max = MIN_VALUE;
        int count = 0;
        /*
         * You don't have to worry about the details
         * about how these machines give load to each other
         *
         */
        for (int load : a) {
            count += (load - target);
            System.out.println(count);
            /*
             * In this process,
              * the least steps we need to eventually
               * finish this process is determined by the peak of
             * abs(cnt) and the max of "gain/lose" array
             */
            max = Math.max(Math.abs(count), Math.max(max, load - target));
        }
        return max;
    }

    // Time : O(n), Space : O(1)
    // https://discuss.leetcode.com/topic/80059/easy-understand-solution-o-n-time-and-o-1-space
    public int findMinMoves2(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if (sum % a.length != 0) {
            return -1;
        }
        int toLeft, toRight, max, target;
        toLeft = 0;
        target = sum / a.length;
        max = MIN_VALUE;
        for (int val : a) {
            toRight = val - target - toLeft;
            max = max(toRight, toLeft, max, toLeft + toRight);
            toLeft = -toRight;
        }
        return max;
    }

    private int max(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SuperWashingMachines obj = new SuperWashingMachines();
        int res = -1;
        int a[] = {1, 0, 5 };
        res = obj.findMinMoves(a);
        System.out.println(res);
      //  int b[] = {0, 3, 0 };
       // res = obj.findMinMoves(b);
       // System.out.println(res);
        //int c[] = {0, 2, 0 };
        //res = obj.findMinMoves(c);
        //System.out.println(res);

    }

}


/**
 * Created by hadoop on 25/12/17.
 */
 class MinMoves {
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
