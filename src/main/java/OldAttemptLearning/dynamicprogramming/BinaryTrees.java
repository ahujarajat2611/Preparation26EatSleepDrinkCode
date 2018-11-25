package OldAttemptLearning.dynamicprogramming;

/**
 * Created by hadoop on 3/8/17.
 */
public class BinaryTrees {
    public static void main(String[] args) {
        BinaryTrees binaryTrees = new BinaryTrees();
        System.out.println(binaryTrees.numTrees(3));
    }
    public int numTrees(int n){
        return dfsCache(0,n-1);
    }

    private int dfsCache(int L, int R) {

        if (L >= R) {
            return 1;
        }
        // if( L>=R){
        // return 1
        //}
        int total = 0;
        for(int i=L;i<=R;i++){
            total = total + dfsCache(L,i-1)*dfsCache(i+1,R);
        }
        return total;
    }
}