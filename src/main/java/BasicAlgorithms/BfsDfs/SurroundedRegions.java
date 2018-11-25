package BasicAlgorithms.BfsDfs;
import java.util.*;

/**
 * Created by hadoop on 22/10/17.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int[] shift = {0, 1, 0, -1, 0};
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            fill(board, 0, i, shift);
            fill(board, m - 1, i, shift);
        }

        for (int i = 0; i < m; i++) {
            fill(board, i, 0, shift);
            fill(board, i, n - 1, shift);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void fill(char[][] board, int i, int j, int[] shift) {
        if (board[i][j] == 'X') {
            return;
        }
        board[i][j] = '*';
        Queue<Integer> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        int index = i * n + j;
        queue.offer(index);
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int x = code / n;
            int y = code % n;
            for (int k = 0; k < 4; k++) {
                int nextRow = x + shift[k];
                int nextCol = y + shift[k + 1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && board[nextRow][nextCol] == 'O') {
                    board[nextRow][nextCol] = '*';
                    queue.offer(nextRow * n + nextCol);
                }
            }
        }
    }
}
