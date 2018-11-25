package BasicAlgorithms.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 10/10/17.
 */
public class SpiralPrint {
        public List<Integer> spiralOrder(int[][] matrix) {
            if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
                return new ArrayList<>();
            }
            int n1 = 0;
            int n2 = matrix.length-1;
            int m1 = 0;
            int m2 = matrix[0].length-1;
            List<Integer> list = new ArrayList<>();

            // spiral  take care of edge cases
            // m1 m2
            while (m1< m2 && n1 <n2){
                for(int j=m1;j<m2;j++){
                    list.add(matrix[n1][j]);
                }
                for(int i=n1;i<n2;i++){
                    list.add(matrix[i][m2]);
                }
                for(int j=m2;j>m1;j--){
                    list.add(matrix[n2][j]);
                }
                for(int i=n2;i>n1;i--){
                    list.add(matrix[i][m1]);
                }
                m1++;
                m2--;
                n1++;
                n2--;
            }
            if(n1 == n2 && m1 == m2 ){
            // remaing one point case
                list.add(matrix[n1][m1]);

            }
            else{
                // remaining last row case
                while (m1<=m2 && n1 == n2){
                    list.add( matrix[n1][m1++]);
                }
                // remaining last column case
                while (n1<=n2 && m2 == m1){
                    list.add(matrix[n1++][m1]);
                }
            }

            return list;
        }
    public List<Integer> spiralOrderAgain(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = 0;
        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    res.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    res.add(matrix[x++][y]);
                }
                break;
            }
            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y++]);
            }
            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x++][y]);
            }
            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y--]);
            }
            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x--][y]);
            }
            m = m - 2;
            n = n - 2;
            x++;
            y++;
        }
        return res;
    }
}
