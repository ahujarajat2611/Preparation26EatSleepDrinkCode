package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 18/1/18.
 */
public class CountComponents {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] e : edges) {
            unionFind.union(e[0], e[1]);
        }
        return unionFind.size;
    }

    private class UnionFind {
        int[] roots;
        int size;

        public UnionFind(int n) {
            this.roots = new int[n];
            Arrays.fill(roots, -1);
            size = n;
        }

        public int find(int x) {
            if (roots[x] < 0) {
                return x;
            }
            // once we get the parent // we are updating its parent as wel !!!
            roots[x] = find(roots[x]);
            return roots[x];
        }

        //false if already in the same union
        //true if successfully union these two vertices
        public boolean union(int x, int y) {
            if (x == y) {
                return false;
            }
            int r1 = find(x);
            int r2 = find(y);
            if (r1 == r2) {
                return false;
            }
            if (roots[r1] > roots[r2]) {
                roots[r1] = r2;
            } else {
                if (roots[r1] == roots[r2]) {
                    roots[r1]--;
                }
                roots[r2] = r1;
            }
            size--;
            return true;
        }
    }

}
