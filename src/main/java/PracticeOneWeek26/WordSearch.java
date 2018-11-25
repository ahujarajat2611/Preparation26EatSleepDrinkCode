package PracticeOneWeek26;

/**
 * Created by hadoop on 8/12/17.
 */
public class WordSearch {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0,  0, 1, -1};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null
                || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int height = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) != board[i][j]) {
                    continue;
                }
                if (dfs(0, i, j, visited, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs (int index, int x, int y, boolean[][] visited, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        int height = board.length;
        int width = board[0].length;
        if (x < 0 || x >= height || y < 0 || y >= width || board[x][y] != word.charAt(index) || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (dfs(index + 1, nx, ny, visited, board, word)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
