package BasicAlgorithms.kth;

/**
 * Created by hadoop on 24/10/17.
 */
import java.util.*;
public class KthClosePoints {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1-x) - Math.abs(o2-x);
            }
        });
        int index = 0;
        List<Integer> ans = new ArrayList<>();
        for(int a:arr){
            if(index == k){
                break;
            }
            index++;
            ans.add(a);
        }
        return ans;
    }

    public static void main(String[] args) {
        KthClosePoints kthClosePoints = new KthClosePoints();
        List<Integer> points = new ArrayList<>();
        int []arr = {2,3,1,4,5,9,10,8};
        for(int a:arr){
            points.add(a);
        }
        System.out.println(kthClosePoints.findClosestElements(points,3,11));
    }
}