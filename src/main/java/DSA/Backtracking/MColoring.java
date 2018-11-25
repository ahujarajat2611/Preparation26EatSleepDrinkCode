/**
 * 
 */
package DSA.Backtracking;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * @author Raj
 *
 */
public class MColoring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MColoring obj = new MColoring();
		int a[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int m = 3;
		obj.solveMColoring(a, m);
	}

	public void solveMColoring(int[][] a, int m) {
		int n = a.length;
		int sol[] = new int[n];
		int ver = 0;
		if (solveMColoringUtil(a, n, ver, sol, m)) {
			ConsoleWriter.printArray(sol);
		} else {
			System.out.println("no solution");
		}
	}

	public boolean solveMColoringUtil(int[][] a, int n, int ver, int[] sol, int m) {
		if (ver == n)
			return true;
		for (int color = 1; color <= m; color++) {
			if (isSafe(a, n, ver, color, sol)) {
				sol[ver] = color;
				if (solveMColoringUtil(a, n, ver + 1, sol, m))
					return true;
					sol[ver] = 0;
			}
		}
		return false;
	}

	public boolean isSafe(int[][] a, int n, int ver, int color, int[] sol) {
		for (int i = 0; i < ver; i++) {
			// Check previous edge exisist and color of taht node is not same as this color ... kind of checck
			 // all of its parents and check color if color is same then return false else return true!!!
			if (a[ver][i] == 1 && sol[i] == color)
				return false;
		}
		return true;
	}

}
