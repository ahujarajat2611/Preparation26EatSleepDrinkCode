package DSA.Array;

import java.util.Stack;

/**
 * Created by hadoop on 10/2/18.
 */
/*
/*
	 * Given a sequence of non-negative integers,
	 * find the subsequence of length
	 * 3 having maximum product with the numbers of the subsequence
	 * being in
	 * ascending order.

 */
/*
For every index i starting 1 to n-2 (0 based index) find maximum on the left (from index 0 to i-1) less than current element and maximum on the right (i+1 to n-1) greater than current element. Maximum product of sub-sequence containing A[i] as the middle element is left_max * A[i] * right_max. Keep track of maximum among these.

 */
public class MaximumProduct3Sequence {
    public void findIncreasingSubsequenceOfLengthThreeWithMaxProduct(int a[], int n) {

        if (n < 3)
            return;
        // left greater elements
        int lg[] = new int[n];

        // right greater elements
        int rg[] = new int[n];

        int max = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (max > a[i]) {
                rg[i] = max;
            } else {
                max = a[i];
                rg[i] = -1;
            }
        }

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (rg[i] == -1) {
                lg[i] = -1;
                continue;
            }
            max = -1;
            while (!s.isEmpty() && a[i] > s.peek()) {
                max = s.pop();
            }
            lg[i] = max;
            s.push(a[i]);
        }

        int maxProduct = 0, curProd = 0;
        int b, c, d;
        b = c = d = 0;
        for (int i = 0; i < n; i++) {
            curProd = lg[i] * rg[i] * a[i];
            if (curProd > maxProduct) {
                maxProduct = curProd;
                b = lg[i];
                c = a[i];
                d = rg[i];
            }
        }
        System.out.println("1st=" + b + ",2nd=" + c + ",3rd=" + d);
    }
}
