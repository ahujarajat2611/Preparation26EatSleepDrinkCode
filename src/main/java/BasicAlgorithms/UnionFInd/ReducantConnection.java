package BasicAlgorithms.UnionFInd;

/**
 * Created by hadoop on 25/11/17.
 */
public class ReducantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len+1];
        for(int i=0;i<len+1;i++){
            parent[i] = i;
        }
        for(int [] edge:edges){
            if(!unionFind(parent,edge[0],edge[1])){
                return edge;
            }
        }
        return new int[2];
    }

    private boolean unionFind(int[] parent, int u, int v) {
        int parentu = find(parent,u);
        int parentv = find(parent,v);
        if(parentu == parentv){
            return false;
        }
        else {
            parent[parentu] = parentv;
            return true;
        }
    }

    private int find(int[] parentArray,int x){
        int parent = parentArray[x];
        while (parent!=parentArray[parent]){
            parent = parentArray[parent];
        }
        return parent;
    }
}