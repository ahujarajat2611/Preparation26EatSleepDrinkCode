/**
 *
 */
package DSA.Backtracking;


import BasicAlgorithms.utils.ConsoleWriter;

/**
 * @author Raj
 *
 *         // @formatter:off
 * 
 * 
 *         You are given a 2D char matrix representing the game board. 'M'
 *         represents an unrevealed mine, 'E' represents an unrevealed empty
 *         square, 'B' represents a revealed blank square that has no adjacent
 *         (above, below, left, right, and all 4 diagonals) mines, digit ('1' to
 *         '8') represents how many mines are adjacent to this revealed square,
 *         and finally 'X' represents a revealed mine.
 * 
 *         Now given the next click position (row and column indices) among all
 *         the unrevealed squares ('M' or 'E'), return the board after revealing
 *         this position according to the following rules:
 * 
 *         If a mine ('M') is revealed, then the game is over - change it to
 *         'X'. If an empty square ('E') with no adjacent mines is revealed,
 *         then change it to revealed blank ('B') and all of its adjacent
 *         unrevealed squares should be revealed recursively. If an empty square
 *         ('E') with at least one adjacent mine is revealed, then change it to
 *         a digit ('1' to '8') representing the number of adjacent mines.
 *         Return the board when no more squares will be revealed
 * 
 *         //@formatter:on
 */
public class MinesweeperMine {

	public void updateBoard(char[][] a, int[] click) {
		int x = click[0];
		int y = click[1];
		// if it's Mine, put 'X' and stop
		dfs(a,x,y);
	}

	private void dfs(char[][] a, int x, int y) {

		if (a[x][y] == 'M') {
			a[x][y] = 'X';
			return;
		} else {

			int count = countMines(a, x, y);
			if (count > 0) {
				// if surrounded by 'mines' put count and stop
				a[x][y] = (char) (count + '0');
				return;
			}
			else {
				a[x][y] = 'B';
			}
		}

		for (int[] move : moves) {
			int _x = x + move[0];
			int _y = y + move[1];
			if (isSafe(a, _x, _y) && a[_x][_y] == 'E') {
					dfs(a, _x, _y);
			}
		}
	}

	private int countMines(char a[][], int x, int y) {
		int count = 0;
		for (int[] move : moves) {
			int _x = x + move[0];
			int _y = y + move[1];
			if (isSafe(a, _x, _y) && a[_x][_y] == 'M') {
				count++;
			}
		}
		return count;
	}

	private boolean isSafe(char[][] a, int x, int y) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
	}

	int moves[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };

	public static void main(String[] args) {
		MinesweeperMine obj = new MinesweeperMine();
		// @formatter:off
		char[][] a = new char[][] { { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' } };
		int click1[] = { 3, 0 };
		char[][] b = new char[][] { { 'B', '1', 'E', '1', 'B' }, { 'B', '1', 'M', '1', 'B' },
				{ 'B', '1', '1', '1', 'B' }, { 'B', 'B', 'B', 'B', 'B' } };
		int click2[] = { 1, 2 };
		// @formatter:on
		int m = a.length, n = a[0].length;
		print2DArray(a, m, n);
		System.out.println("==========");
		obj.updateBoard(a, click1);
		print2DArray(a, m, n);
		System.out.println("==========");

		print2DArray(b, m, n);
		System.out.println("==========");

		obj.updateBoard(b, click2);
		print2DArray(b, m, n);
		System.out.println("==========");
	}
	public static void print2DArray(char[][] t, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}
/*
/usr/lib/jvm/java-8-oracle/bin/java -javaagent:/home/hadoop/work/idea/lib/idea_rt.jar=45209:/home/hadoop/work/idea/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-oracle/jre/lib/charsets.jar:/usr/lib/jvm/java-8-oracle/jre/lib/deploy.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/jfxrt.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-oracle/jre/lib/javaws.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jce.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jfr.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jfxswt.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jsse.jar:/usr/lib/jvm/java-8-oracle/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-oracle/jre/lib/plugin.jar:/usr/lib/jvm/java-8-oracle/jre/lib/resources.jar:/usr/lib/jvm/java-8-oracle/jre/lib/rt.jar:/home/hadoop/gfaltmwu/Preparation26EatSleepDrinkCode/target/classes DSA.Backtracking.Minesweeper
E E E E E
E E M E E
E E E E E
E E E E E
==========
B 1 E 1 B
B 1 M 1 B
B 1 1 1 B
B B B B B
==========
B 1 E 1 B
B 1 M 1 B
B 1 1 1 B
B B B B B
==========
B 1 E 1 B
B 1 X 1 B
B 1 1 1 B
B B B B B
==========
 */
}
