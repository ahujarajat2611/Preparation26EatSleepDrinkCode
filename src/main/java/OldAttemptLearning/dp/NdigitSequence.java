package OldAttemptLearning.dp;

/**
 * Created by hadoop on 11/8/17.
 */
public class NdigitSequence {
    public static void main(String[] args) {
        int n=2;
        int array[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
                {-1,0,-1}
        };
        int total =0;
        for(int i=0;i<array.length;i++){
            for ( int j=0;j<array[0].length;j++){
                if(array[i][j]!=-1) {
                    total = total + recur(n, array, i,j);
                }
            }
        }
        System.out.println("total"+total);
    }

    private static int recur(int n, int[][] array,int i,int j) {
        if(n<0){
            return 1;
        }
        if(n==0){
            return 1;
        }
            int path =0;
            path = path + recur(n-1,array,i,j);
            if(i-1>=0 && array[i-1][j]!=-1)
                path = path + recur(n-1,array,i-1,j);
            if(j-1>=0 && array[i][j-1]!=-1)
                path=path+recur(n-1,array,i,j-1);
            if(i+1<array.length && array[i+1][j]!=-1)
                path = path + recur(n-1,array,i+1,j);
            if(j+1<array[0].length && array[i][j+1]!=-1)
                path = path +recur(n-1,array,i,j+1);
            return path;
    }
}
