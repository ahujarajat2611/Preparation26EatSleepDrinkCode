package BasicAlgorithms.Graph;

/**
 * Created by hadoop on 25/12/17.
 */
public class MineSweeper {
    int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    // frmo click pooint
    // try to find how many mines in its 8 child
    // if we could find     how many mines . update that
    // and if we coulc not find min then star t recursion from all of its 8
    /// child until u hit mine ....
    private void dfs(char[][] b, int i, int j) {
        if (b[i][j] != 'E') return;

        int num = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < b.length && y >= 0 && y < b[0].length && b[x][y] == 'M') num++;
        }
        b[i][j] = num == 0 ? 'B' : (char) ('0' + num);

        if (num == 0) {
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x >= 0 && x < b.length && y >= 0 && y < b[0].length) dfs(b, x, y);
            }
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') board[x][y] = 'X';
        else dfs(board, x, y);
        return board;
    }
}
