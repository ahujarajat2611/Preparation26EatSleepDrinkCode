package DSA.Dp;

public class MaximumSumForIncreasingSubSequence {
	public static void main(String[] args) {
		MaximumSumForIncreasingSubSequence obj = new MaximumSumForIncreasingSubSequence();
		int result = -1;
		// int a[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int a[] = { 1, 101, 2, 3, 100, 4, 5 };
		// int a[] = { 10, 5, 4, 3 };
		result = obj.misDpOn2(a);
		System.out.println(result);
	}

	public int misDpOn2(int[] a) {
		int maxSum = 0, n = a.length;
		if (n <= 0)
			return -1;

		int c[] = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = a[i];
		}

		maxSum = c[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					c[i] = Math.max(c[i], c[j] + a[i]);
					maxSum = Math.max(maxSum, c[i]);
				}
			}
		}

		return maxSum;
	}
}
