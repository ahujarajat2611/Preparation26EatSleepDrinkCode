package OldAttemptLearning.DisjointDatastructure;

/**
 * Created by hadoop on 26/8/17.
 */
public class DisjointUnionSets {
    int [] rank,parent;
    int n;

    public DisjointUnionSets(int n){
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeset();
    }

    private void makeset() {
        for ( int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    int find (int x){
        if(parent[x]!=x){
            parent[x] = find(x);
        }
        return parent[x];
    }


}
