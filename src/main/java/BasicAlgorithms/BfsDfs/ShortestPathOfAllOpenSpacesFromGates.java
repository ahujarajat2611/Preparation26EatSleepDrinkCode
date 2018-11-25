package BasicAlgorithms.BfsDfs;

/**
 * Created by hadoop on 13/2/18.
 */
import java.util.*;
public class ShortestPathOfAllOpenSpacesFromGates {
//    X - exit
//    W - wall
//    O - open space
//
//    distance of every open space from closest exit
//


    class Solution {
        //char matrix[][];
        int m;
        int n;

        int[][] distanceShortest(char[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;

            int distance[][] = new int[m][n];
            boolean visited[][] = new boolean[m][n];
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'E') {
                        queue.add(i * n + j);
                        visited[i][j] = true;
                        distance[i][j] = 0;
                    }
                }
                bfs(matrix, visited, distance, queue);
            }
            return distance;
        }

        void bfs(char[][] matrix, boolean[][] visited, int[][] distance, Queue<Integer> queue) {
            int[] dirx = {1, 0, -1, 0};
            int[] diry = {0, 1, 0, -1};

            while (!queue.isEmpty()) {
                int pos = queue.poll();
                int x = pos / n;
                int y = pos % n;

                for (int k = 0; k < 4; k++) {
                    int newx = x + dirx[k];
                    int newy = y + diry[k];
                    if (isValid(newx, newy) && matrix[newx][newy] == 'O' && !visited[newx][newy] && matrix[newx][newy] != 'W' && matrix[newx][newy] != 'W') {
                        distance[newx][newy] = distance[x][y] + 1;
                        visited[newx][newy] = true;
                        queue.add(newx * n + newy);
                    }
                }
            }
        }

        boolean isValid(int i, int j) {
            if (i >= 0 && i < m && j >= 0 && j < n && j >= 0 && j < n) {
                return true;
            }
            return false;
        }
    }
}
