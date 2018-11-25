package BasicAlgorithms.Array;

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
		int global = A[0];
		int local = A[0];
		for (int i = 1; i < A.length; i++) {
			local = Math.max(local+A[i], A[i]);
			global = Math.max(global, local);
		}
		return global;
	}
}