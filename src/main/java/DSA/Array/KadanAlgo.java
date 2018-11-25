package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class KadanAlgo {
    KadaneResult largestContiguousSumUsingKadane(int a[], int n) {
        int maxSum = 0;
        int maxStart = -1;
        int maxEnd = -1;

        int curSum = 0;
        int curStart = 0;

        for (int i = 0; i < n; i++) {
            curSum += a[i];
            if (curSum < 0) {
                curSum = 0;
                curStart = i + 1;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                maxStart = curStart;
                maxEnd = i;
            }
        }
        return new KadaneResult(maxSum, maxStart, maxEnd);
    }
    class KadaneResult {

        int maxSum;
        int maxStart;
        int maxEnd;

        public KadaneResult(int maxSum, int maxStart, int maxEnd) {
            super();
            this.maxSum = maxSum;
            this.maxStart = maxStart;
            this.maxEnd = maxEnd;
        }

        @Override
        public String toString() {
            return "KadaneResult [maxSum=" + maxSum + ", maxStart=" + maxStart + ", maxEnd=" + maxEnd + "]";
        }

    }
}
