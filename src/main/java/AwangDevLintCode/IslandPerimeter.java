package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    // for all 1 add 4 to its permister and if its childresnsa re valid reduce by 1
                    // so fuckning awesome !!
                    for (int k = 0; k < dx.length; k++) {
                        int mX = i + dx[k];
                        int mY = j + dy[k];
                        if (mX >= 0 && mY >= 0 && mX < grid.length && mY < grid[0].length && grid[mX][mY] == 1) {
                            count -= 1;
                        }
                    }
                }
            }
        }
        return count;
    }
}
