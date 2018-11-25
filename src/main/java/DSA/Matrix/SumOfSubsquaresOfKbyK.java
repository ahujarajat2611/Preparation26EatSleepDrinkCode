package DSA.Matrix;

import BasicAlgorithms.utils.ConsoleWriter;

public class SumOfSubsquaresOfKbyK {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5 }, };
		int m = a.length, n = a[0].length;
		int k = 3;

		SumOfSubsquaresOfKbyK obj = new SumOfSubsquaresOfKbyK();
//		obj.sumofSubsquresofKbyK(a, m, n, k);

		int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, };
		int m1 = b.length, n1 = b[0].length, k1 = 2;
		ConsoleWriter.printIntArray(b, m1, n1);
		obj.sumofSubsquresofKbyK(b, m1, n1, k1);
	}

	// Time : O(n2)
	// first we calculate sum of one size
	// int verticalsum [m-k+1][n]
	//
	public void sumofSubsquresofKbyK(int[][] a, int m, int n, int k) {
		// calculate vertical sum for each colun
		int verticalSum[][] = new int[m - k + 1][n];
		for (int j = 0; j < n; j++) {
			int sum = 0;
			for (int i = 0; i < k; i++)
				sum += a[i][j];
			verticalSum[0][j] = sum;
			for (int i = 1; i < m - k + 1; i++) {
				sum += (a[i + k - 1][j] - a[i - 1][j]);
				verticalSum[i][j] = sum;
			}
		}
		// row k sum calculates
		// now columnk sum needs to be calculate sin reult
		int result[][] = new int[m - k + 1][n - k + 1];
		for (int i = 0; i < m - k + 1; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++)
				sum += verticalSum[i][j];
			result[i][0] = sum;
			for (int j = 1; j < n - k + 1; j++) {
				sum += (verticalSum[i][j + k - 1] - verticalSum[i][j - 1]);
				result[i][j] = sum;
			}
		}

		// CommonUtil.print2DArray(verticalSum, m - k + 1, n);
		ConsoleWriter.printIntArray(result, m - k + 1, n - k + 1);
	}

}
