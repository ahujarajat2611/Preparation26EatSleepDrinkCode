package BasicAlgorithms.Sort;

import java.util.ArrayList;

/**
 * Created by hadoop on 24/10/17.
 */
import java.util.*;
public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int num:nums){
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a= String.valueOf(o1) + String.valueOf(o2);
                String b = String.valueOf(o2) + String.valueOf(o1);
                return b.compareTo(a);
            }
        });
        String ans= "";
        for(Integer a:list){
            System.out.println(a);
            ans= ans + a;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        largestNumber.largestNumber(new int[]{10,1,4,0,40});
    }
}