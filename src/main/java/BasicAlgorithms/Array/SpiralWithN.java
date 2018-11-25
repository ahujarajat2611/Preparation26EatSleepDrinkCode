package BasicAlgorithms.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 11/10/17.
 */
public class SpiralWithN {
    public int [][] spiralOrder(int n) {
        int [][]matrix = new int[n][n];
        int n1 = 0;
        int n2 = matrix.length-1;
        int m1 = 0;
        int m2 = matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        int ans = 1;
        while (m1< m2 && n1 <n2){
            for(int j=m1;j<m2;j++){
                matrix[n1][j] = ans++;
            }
            for(int i=n1;i<n2;i++){
                matrix[i][m2] = ans++;
            }
            for(int j=m2;j>m1;j--){
                matrix[n2][j] = ans++;
            }
            for(int i=n2;i>n1;i--){
                matrix[i][m1] = ans++;
            }
            m1++;
            m2--;
            n1++;
            n2--;
        }
        if(n1 == n2 && m1 == m2 ){
            matrix[n1][m1] = ans++;
        }
//        else{
//            while (m1<=m2 && n1 == n2){
//                list.add( matrix[n1][m1++]);
//            }
//            while (n1<=n2 && m2 == m1){
//                list.add(matrix[n1++][m1]);
//            }
//        }

        return matrix;
    }
}
