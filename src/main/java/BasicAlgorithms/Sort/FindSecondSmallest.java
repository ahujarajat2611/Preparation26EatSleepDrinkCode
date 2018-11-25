package BasicAlgorithms.Sort;

/**
 * Created by hadoop on 11/11/17.
 */
public class FindSecondSmallest {
    public int findSecondSmallest(int[] a){

        //We assume that the array has at least 2 elements
        return findMinAnd2ndSmallest(a, 0, a.length-1)[1];
    }

    //find min & second smallest
    private int[] findMinAnd2ndSmallest(int[] a, int start, int end){
        if(start == end) return new int[]{a[start], Integer.MAX_VALUE};

        int mid = (start+ end)/2;

        int[] left = findMinAnd2ndSmallest(a, start, mid);
        int[] right = findMinAnd2ndSmallest(a,mid+1, end);
        int smallest = 0, secondSmallest = 0;
        if(left[0] < right[0]) {
            smallest = left[0]; secondSmallest = right[0];
            if(right[0] > left[1]) secondSmallest = left[1];
        }else {
            smallest = right[0]; secondSmallest = left[0];
            if(left[0] > right[1]) secondSmallest = right[1];
        }
        return new int[]{smallest, secondSmallest};
    }
}
