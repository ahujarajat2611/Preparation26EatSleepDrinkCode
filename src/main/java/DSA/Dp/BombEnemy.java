/**
 * 
 */
package DSA.Dp;

/**
 * @author Raj
 *
 *         Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or
 *         empty '0' (the number zero), return the maximum enemies you can kill
 *         using one bomb. The bomb kills all the enemies in the same row and
 *         column from the planted point until it hits the wall since the wall
 *         is too strong to be destroyed. Note that you can only put the bomb at
 *         an empty cell. Example: For the given grid
 * 
 *         0 E 0 0 E 0 W E 0 E 0 0
 * 
 *         return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 */
public class BombEnemy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BombEnemy obj = new BombEnemy();
		char[][] matrix = { { '0', 'E', '0', '0' }, { 'E', '0', 'W', 'E' }, { '0', 'E', '0', '0' } };

		int result = obj.maxEnemies(matrix);
		System.out.println(result);

	}

	public int maxEnemies(char[][] a) {
		int m = a.length;
		int n = a[0].length;
		int maxEnemiess = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == '0') {
					int enemiesKilled = countEnemies(a, i, j);
					// System.out.println(enemiesKilled);
					maxEnemiess = Math.max(maxEnemiess, enemiesKilled);
				}
			}
		}
		return maxEnemiess;
	}

	private int countEnemies(char[][] a, int x, int y) {
		int enemies = 0;
		int i = x + 1;
		while (i < a.length && a[i][y] == 'E') {
			enemies++;
			i++;
		}

		i = x - 1;
		while (i >= 0 && a[i][y] == 'E') {
			enemies++;
			i--;
		}

		int j = y + 1;
		while (j < a[0].length && a[x][j] == 'E') {
			enemies++;
			j++;
		}

		j = y - 1;
		while (j >= 0 && a[x][j] == 'E') {
			enemies++;
			j--;
		}
		return enemies;
	}



/**
 * Created by hadoop on 3/2/18.
 */
/*
/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
*/

/*
Thoughts:
It goes off towards 4 difference directions: UP/DOWN/LEFT/RIGHT
Normally: we could traverse the 2D map, use each point to go 4 directions: O(MN*(M+N)) ~ O(MN^2) or O(NM^2)
Need to optimize: standing on any point, the 4 directions are likely to be calculated in earlier time.
Consider UP case:
up[i][j]: the # of bombed enemy at (i,j) can be:
1. up[i-1][j], if grid[i-1][j]== '0'
2. up[i-1][j] + 1 if grid[i-1][j]== 'E'
3. 0, if grid[i-1][j]== 'W'

We'll sum up UP/DOWN/LEFT/RIGHT at the end. During initialize of the 4 directions, ignore 'W'.

dp[i][j] = UP[i][j] + DOWN[i][j] + LEFT[i][j] + RIGHT[i][j].

*/

	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] up = new int[m][n];
		int[][] down = new int[m][n];
		int[][] left = new int[m][n];
		int[][] right = new int[m][n];

		// UP
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 'W') {
					up[i][j] = grid[i][j] == 'E' ? 1 : 0;
					up[i][j] += i - 1 >= 0 ? up[i - 1][j] : 0;
				}
			}
		}

		// DOWN
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 'W') {
					down[i][j] = grid[i][j] == 'E' ? 1 : 0;
					down[i][j] += i + 1 < m ? down[i + 1][j] : 0;
				}
			}
		}

		// LEFT
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 'W') {
					left[i][j] = grid[i][j] == 'E' ? 1 : 0;
					left[i][j] += j - 1 >= 0 ? left[i][j - 1] : 0;
				}
			}
		}

		// RIGHT
		for (int i = 0; i < m; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] != 'W') {
					right[i][j] = grid[i][j] == 'E' ? 1 : 0;
					right[i][j] += j + 1 < n ? right[i][j + 1] : 0;
				}
			}
		}


		// DP
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '0') {
					max = Math.max(max, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
				}
			}
		}
		return max;
	}
}
