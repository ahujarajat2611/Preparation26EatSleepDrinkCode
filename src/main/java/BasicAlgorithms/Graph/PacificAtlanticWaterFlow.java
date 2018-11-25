package BasicAlgorithms.Graph;

import java.util.*;
/**
 * Created by hadoop on 16/1/18.
 */
public class PacificAtlanticWaterFlow {
    private static final int dx[] = {0, 0, -1, 1};
    private static final int dy[] = {1, -1, 0, 0};

    public List<Integer> pacificAtlantic(int[][] matrix) {
        List<Integer> rst = new ArrayList();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return rst;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean pacific[][] = new boolean[rows][cols];
        boolean atlantic[][] = new boolean[rows][cols];

        for(int i = 0; i < rows ;i++){
            flow(pacific, matrix, i, 0);
            flow(atlantic, matrix,i, cols - 1);
        }
        for(int j = 0; j < cols; j++){
            flow(pacific, matrix, 0, j);
            flow(atlantic,matrix, rows - 1, j);
        }
        for(int i = 0;i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacific[i][j] && atlantic[i][j]) {
                    // rst.add(new int[] {i, j});
                    System.out.println("ans");
                }
            }
        }
        return rst;

    }

    private void flow(boolean visited[][],int matrix[][],int x,int y){
        visited[x][y] = true;
        for(int i = 0;i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            // water will keep flowing if child is more than parent metrics
            if(nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length
                    && !visited[nx][ny] && matrix[nx][ny] >= matrix[x][y]){
                flow(visited, matrix, nx, ny);
            }
        }
    }
}

