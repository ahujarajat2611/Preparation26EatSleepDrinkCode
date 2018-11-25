package BasicAlgorithms.Array;

/**
 * Created by hadoop on 10/10/17.
 */
public class SparseMatrixMultiplication {
    public int [][]multiple(int [][]A,int [][]B){
        int m = A.length;
        int n = A[0].length;
        int nb = B[0].length;

        int answer[][] = new int[m][nb];
        for(int i=0;i<m;i++){
            for(int k =0;k<n;k++){
                if(A[i][k]!=0)
                for(int j=0;j<nb;j++){
                    answer[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        return answer;
    }
}
