package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
Thanks to Yu’s Garden blog
Thinking process:
0.   Use two pointers pStart and pEnd
to track the potential locations we can move to.
Consider a range from current spot to the farthest spot:
 try to find a max value from this range,
 and see if the max can reach the tail of array.

If no max can read the tail of array,
that means we need to move on. At this point, let pStart = pEnd + 1. At same time, move pEnd to the max spot we can go to. Since pEnd moves forward, we could step++
If max reach the tail of array, return the steps.
 */
public class JumpGame {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int pStart = 0;
        int pEnd = 0;
        int steps = 0;
        while (pEnd < A.length - 1) {
            steps++;    //Cound step everytime when pEnd is moving to the farthest.
            int farthest = 0;
            //Find farest possible and see if reach the tail
            for (int i = pStart; i <= pEnd; i++) {
                farthest = Math.max(farthest, i + A[i]);
                if (farthest >= A.length - 1) {
                    return steps;
                }
            }
            //Re-select pointer position for publish and end
            pStart = pEnd + 1;
            pEnd = farthest;
        }
        return -1;  //This is the case where no solution can be found.
    }
    public boolean canJumpGreedy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        long farest = 0;
        for (int i = 0; i < nums.length; i++) {
            farest = Math.max(farest, i + nums[i]);
            if (farest >= nums.length - 1) {
                return true;
            }
            if (farest == i) {
                return false;
            }
        }
        return true;
    }
    /*
Thoughts:
Can/Cannot -> DP.
f[x] = if able to reach f[x], store true/false
if (f[x-1] >= 1), then able to reach f[x]
becomes: if able to jump to f[x-1].
equation:
f[x] = f[x-1] && A[x-1] >= x - 1
f[0] = true
*/
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        final boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && (nums[j] + j >= i)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
