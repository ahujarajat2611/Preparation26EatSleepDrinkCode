package BasicAlgorithms.HashTable;
import java.util.*;
class checkDuplicateWithinK {

	public static boolean checkDuplicateWithinK(int[][] mat, int k) {

		class Cell {
			int row;
			int col;

			public Cell(int r, int c) {
				this.row = r;
				this.col = c;
			}
		}

		int n = mat.length;
		int m = mat[0].length;
		k = Math.min(k, n * m);

		Map<Integer, Set<Cell>> map = new HashMap<Integer, Set<Cell>>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map.containsKey(mat[i][j])) {
					for (Cell c : map.get(mat[i][j])) {
						int manhattanDist = Math.abs(i - c.row) + Math.abs(j - c.col);

						if (manhattanDist <= k) {
							return true;
						}

						if (i - c.row > k) {
							map.remove(c);
						}
					}

					map.get(mat[i][j]).add(new Cell(i, j));
				} else {
					map.put(mat[i][j], new HashSet<Cell>());
					map.get(mat[i][j]).add(new Cell(i, j));
				}
			}
		}

		return false;
	}

	public static boolean checkDuplicateWithinKMineWhichLooksMuchBetter(int[][] mat, int k) {

		class Cell {
			int row;
			int col;

			public Cell(int r, int c) {
				this.row = r;
				this.col = c;
			}
		}

		int n = mat.length;
		int m = mat[0].length;
		k = Math.min(k, n * m);

		Map<Integer, Set<Cell>> map = new HashMap<Integer, Set<Cell>>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map.containsKey(mat[i][j])){
				    Set<Cell> allPos = map.get(mat[i][j]);
				    for(Cell cell:allPos){
				    	int dis = Math.abs(i-cell.row)+ Math.abs(j-cell.col);
				    	if(dis<=k){
				    		return true;
						}
					}
					map.get(mat[i][j]).add(new Cell(i,j));
				}
				else {
					if (i >= k) {
						map.remove(mat[i - k][j]);
					}
					Set<Cell> set = new HashSet<Cell>();
					set.add(new Cell(i,j));
					map.put(mat[i][j],set);
				}
			}
		}
		return false;
	}

}