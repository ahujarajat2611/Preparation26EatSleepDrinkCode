package BasicAlgorithms.Array;

/**
 * Created by hadoop on 16/12/17.
 */
public class RotateMatrix {
    void rotate(int [][]matrx){
        int rowstart = 0;
        int rowend = matrx.length-1;
        int columnstart = 0;
        int columnend = matrx[0].length-1;
        while (rowstart<rowend){
            int i=0;
            while (i+rowstart<rowend){
                int temp1 = matrx[rowstart][columnstart+i];
                int temp2 = matrx[rowstart+i][columnend];
                int temp3 = matrx[rowend][columnend-i];
                int temp4 = matrx[rowend-i][columnstart];
                i++;
                matrx[rowstart][columnstart+i] = temp4;
                matrx[rowstart+i][columnend] = temp1;
                matrx[rowend][columnend-i] = temp2;
                matrx[rowend-i][columnstart] = temp3;
            }
            rowstart++;
            rowend--;
            columnstart++;
            columnend--;
        }
    }
}
/*
void rot(vector<vector<int> >& A, int rowStart, int rowEnd, int colStart, int colEnd){

    while(rowStart < rowEnd){
        int i = 0;
        while((i + rowStart) < rowEnd){
            int temp1 = A[rowStart][colStart+i];
            int temp2 = A[rowStart+i][colEnd];
            int temp3 = A[rowEnd][colEnd-i];
            int temp4 = A[rowEnd-i][colStart];

            A[rowStart][colStart+i] = temp4;
            A[rowStart+i][colEnd] = temp1;
            A[rowEnd][colEnd-i] = temp2;
            A[rowEnd-i][colStart] = temp3;
            i++;
        }
        colStart++;
        colEnd--;
        rowStart++;
        rowEnd--;
    }

}
 */