package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class Hindex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int start = 0;
        int end = len - 1;
        while (start<end){
            int mid = start+ (end-start)/2;
            if(citations[mid] >= citations.length-mid){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return citations.length-start;
    }
}
