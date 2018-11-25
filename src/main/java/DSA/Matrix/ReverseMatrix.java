package DSA.Matrix;

import BasicAlgorithms.utils.ConsoleWriter;

import static DSA.Common.CommonUtil.swap;

public class ReverseMatrix {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int m = a.length, n = a[0].length;
		ReverseMatrix obj = new ReverseMatrix();
		ConsoleWriter.printArray(a);
		obj.reverse(a, m, n);
		ConsoleWriter.printArray(a);

	}

	public void reverse(int[][] a, int m, int n) {
		int top = 0, bottom = m - 1;
		int left = 0, right = n - 1;
		while (top < bottom) {
			for (int i = left; i <= right; i++) {
				swap(a, top, i, bottom, i);
			}
			top++;
			bottom--;
		}
	}

}
