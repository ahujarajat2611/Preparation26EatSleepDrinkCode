package BasicAlgorithms.UnionFInd;

/**
 * Created by hadoop on 13/10/17.
 */
public class NumberOfConnectedComponents {
    public static void main(String[] args) {
        int n = 5 ;
        int edges[][] = {{0, 1}, {1, 2}, {3, 4},{2,3}};
        System.out.println(countComponents(n,edges));
    }
    public static int countComponents(int n, int[][] edges) {
        DisjointSet<Integer> disjointSet = new DisjointSet<>();
        for(int i=0;i<n;i++){
            disjointSet.makeset(i);
        }
        for(int i=0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];

            disjointSet.Union(x,y);
        }
        return disjointSet.getCount();
    }
}