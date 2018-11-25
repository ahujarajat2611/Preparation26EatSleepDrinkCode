package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class NumberOfIslands2Simpleer {
    int[] parent;
    int islandCnt = 0;

    int find(int i) {
        return parent[i] == i ? i : (parent[i] = find(parent[i]));
    }

    void union(int i, int j) {
        if (find(i) != find(j)) {
            parent[find(i)] = find(j);
            islandCnt--;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        parent = new int[m * n];
        Arrays.fill(parent, -1);

        List<Integer> ans = new ArrayList<>(positions.length);
        islandCnt = 0;
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0], y = positions[i][1], pos = x * n + y;
            parent[pos] = pos;
            islandCnt++;


            if (x - 1 >= 0 && parent[pos - n] != -1) union(pos, pos - n);
            if (x + 1 < m && parent[pos + n] != -1) union(pos, pos + n);
            if (y - 1 >= 0 && parent[pos - 1] != -1) union(pos, pos - 1);
            if (y + 1 < n && parent[pos + 1] != -1) union(pos, pos + 1);

            ans.add(islandCnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("here");
    }
}
class _305_NumberOfIslands {
    int[] parent;
    Set<Integer> set = new HashSet<>();
    int rows;
    int cols;

    public void union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        if (parentI != parentJ) {
            parent[parentJ] = parentI;
            set.remove(parentJ);
        }
    }

    public int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        parent[i] = find(i);
        return parent[i];
    }

    public void add(int x, int y) {
        parent[x * cols + y] = x * cols + y;
        set.add(x * cols + y);
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && parent[x1 * cols + y1] != -1) {
                union(x1 * cols + y1, x * cols + y);
            }
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        parent = new int[m * n];
        rows = m;
        cols = n;
        for (int i = 0; i < m * n; i++) {
            parent[i] = -1;
        }
        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            add(position[0], position[1]);
            res.add(set.size());
        }
        return res;
    }
}

