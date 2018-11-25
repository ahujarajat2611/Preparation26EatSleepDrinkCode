package BasicAlgorithms.UnionFInd;

import java.util.*;
public class Solution {
    private int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> results = new LinkedList<>();
        UnionFind2D uf = new UnionFind2D(m, n);
        for (int[] position: positions){
            int x = position[0];
            int y = position[1];
            int newPos = uf.convert(x, y);
            uf.add(newPos);
            for (int[] neighbor: neighbors){
                int neighborX = x + neighbor[0];
                int neighborY = y + neighbor[1];
                if (!(neighborX < m && neighborX >= 0 && neighborY < n && neighborY >= 0)){
                    continue;
                }
                int neighborPos = uf.convert(neighborX, neighborY);
                int graphValue = uf.getGraphValue(neighborPos);
                if (graphValue > 0){
                    uf.connect(newPos, neighborPos);
                }
            }
            results.add(uf.getCounter());
        }
        return results;
    }
}

class UnionFind2D {
    private int[] graph;
    private int[] size;
    private int m;
    private int n;
    private int counter;

    public UnionFind2D(int m, int n){
       this.graph = new int[m * n + 1];
       this.size = new int[m * n + 1];
       this.m = m;
       this.n = n;
       this.counter = 0;
    }

    public int convert(int x, int y){
        return x * n + y + 1;
    }

    public void add(int a){
        graph[a] = a;
        size[a] = 1;
        counter++;
    }

    public void connect(int a, int b){
        int aroot = find(a);
        int broot = find(b);
        if (aroot == broot){
            return;
        }
        int asize = size[aroot];
        int bsize = size[broot];
        if (asize <= bsize){
            graph[aroot] = broot;
            size[broot] = asize + bsize;
        } else {
            graph[broot] = aroot;
            size[aroot] = asize + bsize;
        }
        counter--;
    }

    public boolean query(int a, int b){
        return find(a) == find(b);
    }

    public int find(int a){
        while(graph[a] != a){
            a = graph[a];
        }
        return a;
    }

    public int getCounter(){
        return this.counter;
    }

    public int getGraphValue(int a){
        return graph[a];
    }
}