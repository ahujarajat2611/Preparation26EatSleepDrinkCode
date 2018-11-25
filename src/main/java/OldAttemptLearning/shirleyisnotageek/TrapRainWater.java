package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
import java.util.*;
public class TrapRainWater {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m == 0) {
            return 0;
        }
        int n = heightMap[0].length;
        if (n == 0) {
            return 0;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.add(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            pq.add(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.add(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = true;
            pq.add(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[m - 1][j] = true;
        }

        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};
        int sum = 0;
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dirX[i];
                int ny = curr.y + dirY[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    sum += Math.max(0, curr.h - heightMap[nx][ny]);
                    pq.add(new Cell(nx, ny, Math.max(heightMap[nx][ny], curr.h)));
                    visited[nx][ny] = true;
                }
            }
        }
        return sum;
    }

    private class Cell implements Comparable<Cell> {
        int x, y, h;
        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        public int compareTo(Cell other) {
            return h - other.h;
        }
    }
}
