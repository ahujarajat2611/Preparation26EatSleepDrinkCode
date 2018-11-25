package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class FindPivot {
    int findPivot(int a[], int n) {
        int start = 0;
        int end = n-1;
        while (start<end){
            int mid = start + ( end -start)/2;
            if(a[mid] < a[end]){
                end = mid;
            }
            else {
                start = mid +1;
            }
        }
        return start;
    }
}
