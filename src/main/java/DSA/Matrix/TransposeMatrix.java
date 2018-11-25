package DSA.Matrix;

import BasicAlgorithms.utils.ConsoleWriter;

import static DSA.Common.CommonUtil.swap;

public class TransposeMatrix {
	// Time :O(m+n), Space : O(1)
	public void transposeInplace(int[][] a, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < n; j++) {
				swap(a, i, j, j, i);
			}
		}

	}

	public static void main(String args[]) throws Exception {

		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int m = a.length, n = a[0].length;
		TransposeMatrix obj = new TransposeMatrix();
		ConsoleWriter.printArray(a);
		obj.transposeWithExtraSpace(a, m, n);
	}

	public void transposeWithExtraSpace(int[][] a, int m, int n) {
		int t[][] = new int[m][n];
		for (int i = 0, c = 0; i < m; i++, c++) {
			for (int j = 0, r = 0; j < n; j++, r++) {
				t[r][c] = a[i][j];
			}
		}
		ConsoleWriter.printArray(t);
	}

}
