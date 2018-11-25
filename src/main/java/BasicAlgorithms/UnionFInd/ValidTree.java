package BasicAlgorithms.UnionFInd;

/**
 * Created by hadoop on 7/1/18.
 */
public class ValidTree {
    public class Solution {
        public boolean validTree(int n, int[][] edges) {
            UnionFind uf = new UnionFind(n);
            for (int[] edge: edges){
                int a = edge[0];
                int b = edge[1];
                if (uf.query(a, b)){
                    return false;
                }
                uf.connect(a, b);
            }
            int counter = uf.getCounter();
            return counter == 1;
        }
    }

    class UnionFind{
        private int[] graph;
        private int[] size;
        private int counter;

        public UnionFind(int n){
            this.graph = new int[n];
            for (int i = 0; i < graph.length; i++){
                graph[i] = i;
            }
            this.size = new int[n];
            for (int i = 0; i < size.length; i++){
                size[i] = 1;
            }
            this.counter = n;
        }

        public void connect(int a, int b){
            int aroot = find(a);
            int broot = find(b);
            if (aroot == broot){
                return;
            }
            int asize = size[a];
            int bsize = size[b];
            if (asize <= bsize){
                graph[aroot] = broot;
                size[broot] = asize + bsize;
            } else {
                graph[broot] = aroot;
                size[aroot] = asize + bsize;
            }
            this.counter--;
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
    }
}
