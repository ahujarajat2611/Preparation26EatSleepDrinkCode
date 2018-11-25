package DSA.Array;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.*;

/**
 * Created by hadoop on 10/2/18.
 */
public class SortArrayBasedonANotherArray {
    public void sortArrayByAnotherArray(int a[], int m, int b[], int n) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(b[i])) {
                for (int j = 0; j < map.get(b[i]); j++) {
                    a[k++] = b[i];
                }
                map.remove(b[i]);
                //map.put(b[i], 0);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int key : map.keySet()) {
            for (int p = 0; p < map.get(key); p++) {
                // c[index++] = key;
                list.add(key);
            }
        }
        //list.sort();
       // ConsoleWriter.printList(list);
        Collections.sort(list);
       // ConsoleWriter.printList(list);
        for (int i = 0; i < list.size(); i++) {
            a[k++] = list.get(i);
        }
    }


    public static void main(String[] args) {
        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {2, 1, 8, 3};
        SortArrayBasedonANotherArray so = new SortArrayBasedonANotherArray();
        so.sortArrayByAnotherArray(A1,A1.length,A2,A2.length);
        ConsoleWriter.printIntArray(A1);
//        List<Integer> list = new ArrayList<>();
//        list.add(4);
//        list.add(1);
//        ConsoleWriter.printList(list);
//        Collections.sort(list);
//        ConsoleWriter.printList(list);
       // ConsoleWriter.printIntArray(A1);
    }
}
