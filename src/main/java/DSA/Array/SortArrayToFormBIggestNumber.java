package DSA.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class SortArrayToFormBIggestNumber {
    public void sortArrayToFormBiggestNumber(int a[], int n) {
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = Integer.toString(a[i]);
        }

        Arrays.sort(s, sortByBiggestNumber);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }

    private Comparator<String> sortByBiggestNumber = new Comparator<String>() {
        public int compare(String s1, String s2) {
            String xy = s1 + s2;
            String yx = s2 + s1;
            return yx.compareTo(xy);
        }
    };

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(9);
        list.add(5);
        list.add(2);
        list.add(11);
        //Collections.sort(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int x:list){
            System.out.println(x);
        }
    }
}
