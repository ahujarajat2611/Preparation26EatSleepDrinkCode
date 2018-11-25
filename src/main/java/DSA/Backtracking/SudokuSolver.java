/**
 * 
 */
package DSA.Backtracking;


import BasicAlgorithms.utils.ConsoleWriter;

/**
 * @author Raj
 *
 */
public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SudokuSolver obj = new SudokuSolver();
		int[][] a = new int[][] { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		boolean result = false;
		int m = a.length, n = a[0].length;
		ConsoleWriter.printArray(a);
		result = obj.solveSudoku(a, m, n);
		System.out.println(result);
		ConsoleWriter.printArray(a);

	}

	public boolean solveSudoku(int[][] a, int m, int n) {
		Cell cell = getUnassignedLocation(a, m, n);
		if (cell == null) {
			return true;
		}
		for (int i = 1; i <= 9; i++) {
			if (safeToPlace(a, cell.x, cell.y, i)) {
				a[cell.x][cell.y] = i;
				if (solveSudoku(a, m, n))
					return true;
				a[cell.x][cell.y] = 0;
			}
		}

		return false;
	}

	private boolean safeToPlace(int[][] a, int x, int y, int val) {
		return isSafeRow(a, x, y, val) && isSafeColumn(a, x, y, val) && isSafeBlock(a, x - x % 3, y - y % 3, x, y, val);
	}

	public boolean isSafeRow(int[][] a, int x, int y, int val) {
		for (int i = 0; i < 9; i++) {
			if (a[x][i] == val)
				return false;
		}
		return true;
	}

	public boolean isSafeColumn(int[][] a, int x, int y, int val) {
		for (int i = 0; i < 9; i++) {
			if (a[i][y] == val)
				return false;
		}
		return true;
	}

	public boolean isSafeBlock(int[][] a, int startBlockX, int startBlockY, int x, int y, int val) {
		for (int i = startBlockX; i < startBlockX + 3; i++) {
			for (int j = startBlockY; j < startBlockY + 3; j++) {
				if (a[i][j] == val)
					return false;
			}
		}
		return true;
	}

	class Cell {
		int x;
		int y;

		public Cell(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public Cell getUnassignedLocation(int a[][], int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0) {
					return new Cell(i, j);
				}
			}
		}
		return null;
	}
}
