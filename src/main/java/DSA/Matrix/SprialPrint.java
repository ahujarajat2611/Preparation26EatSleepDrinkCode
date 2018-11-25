package DSA.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 15/2/18.
 */
public class SprialPrint {
    public List<Character> spiralOrder(char[][] matrix) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return new ArrayList<>();
        }
        int n1 = 0;
        int n2 = matrix.length-1;
        int m1 = 0;
        int m2 = matrix[0].length-1;
        List<Character> list = new ArrayList<>();

        // spiral  take care of edge cases
        // m1 m2
        char index = 'X';
        while (m1< m2 && n1 <n2){
            for(int j=m1;j<m2;j++){
                list.add(index);
            }
            for(int i=n1;i<n2;i++){
                list.add(index);
            }
            for(int j=m2;j>m1;j--){
                list.add(index);
            }
            for(int i=n2;i>n1;i--){
                list.add(index);
            }
            index = (index == 'X') ? 'O' :'X';
            m1++;
            m2--;
            n1++;
            n2--;
        }
        if(n1 == n2 && m1 == m2 ){
            // remaing one point case
            list.add(index);

        }
        else{
            // remaining last row case
            while (m1<=m2 && n1 == n2){
                list.add( index);
                m1++;
            }
            // remaining last column case
            while (n1<=n2 && m2 == m1){
                list.add(index);
                n1++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        SprialPrint sp = new SprialPrint();
        System.out.println( sp.spiralOrder(new char[][]{{1,2,3,4},
                {4,5,6,5},
                {7,8,9,6},
                {2,3,4,5}}));
    }
}
