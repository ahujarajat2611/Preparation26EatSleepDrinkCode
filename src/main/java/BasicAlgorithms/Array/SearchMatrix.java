package BasicAlgorithms.Array;

/**
 * Created by hadoop on 11/10/17.
 */
public class SearchMatrix {
    public boolean searchMatrix(int [][] matrix,int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;


        // set the low and end pointer efficiently
        int start=0;
        int end = m*n-1;
        while (start<end){
            int mid = (start+end)/2;
            int row = mid/n;
            int column = mid%n;
            if(matrix[row][column] <target){
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        // last check if publish has things
        if(matrix[start/n][start%n] == target){
            return true;
        }
        return false;
    }
}
