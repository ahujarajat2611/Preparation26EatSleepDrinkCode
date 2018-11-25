package smallmomentsmakeitbigger26;
import java.util.*;
/**
 * Created by hadoop on 15/12/17.
 */
public class KClosest {
    public static List<Integer> findClosestElements2(List<Integer> arr, int k, int x) {
        if(x < arr.get(0)) return arr.subList(0, k);
        if(x > arr.get(arr.size()-1)) return arr.subList(arr.size()-k+1, arr.size());

        List<Integer> result = new ArrayList<>();
        int index = binSearch(arr, x);
        System.out.println(index);
        int i = 0; int j = 0;
        if(arr.get(index) == x) {
            result.add(x);
            i = index - 1;
            j = index + 1;
        } else {
            i = index - 1;
            j = index;
        }

        while(i >= 0 && j < arr.size() && result.size() != k) {
            // CHECK FOR DIFF WITH X and keep iterating you take k values
            // whcih everis less update that
            // i-- since i is going to left and j is goinh to right
            if(Math.abs(arr.get(i) - x) <= Math.abs(arr.get(j) - x)) {
                result.add(0, arr.get(i--));
            } else {
                result.add(arr.get(j++));
            }
        }

        if(result.size() == k) {
        } else if(i < 0) {
            result.addAll(arr.subList(j, j + k - result.size()));
        } else {
            result.addAll(0, arr.subList(i+1-k+result.size(), i+1));
        }

        return result;
    }

    public static int binSearch(List<Integer> a, int target) {
        int st = 0;
        int end = a.size() - 1;
        int mid = 0;
        while(st <= end) {
            mid = (st + end)/2;
            if(a.get(mid) == target) {
                break;
            } else if (a.get(mid) > target) {
                end = mid -1;
            } else {
                st = mid +1;
            }
        }
        return mid;
    }
}
