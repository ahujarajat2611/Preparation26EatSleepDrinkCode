package DSA.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.*;
/**
 * Created by hadoop on 10/2/18.
 */
public class CheckDuplicatesWithInK {
    public static boolean checkDuplicateWithinK(int[][] mat, int k) {
        class Cell {
            int row;
            int col;

            public Cell(int r, int c) {
                this.row = r;
                this.col = c;
            }
        }

        int n = mat.length;
        int m = mat[0].length;
        k = Math.min(k, n * m);

        Map<Integer, Set<Cell>> map = new HashMap<Integer, Set<Cell>>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.containsKey(mat[i][j])) {
                    // iterate through all the previous values
                    // having same Key and then see if manhattan distance is
                    // less than k .. also remove elements if row diff is more than k
                    // dont forget to add its own index in the list
                    for (Cell c : map.get(mat[i][j])) {
                        int manhattanDist = Math.abs(i - c.row) + Math.abs(j - c.col);

                        if (manhattanDist <= k) {
                            return true;
                        }
                        // since we are
                        // traversing Row wise hence
                        // removal of those elements using map.remove()
                        // if diff is more than k of row wise then we are
                        // sure that manhattan distance is more than k

                        /// Must optimization problem it is
                        if (i - c.row > k) {
                            map.remove(c);
                        }
                    }
                    map.get(mat[i][j]).add(new Cell(i, j));
                } else {
                    // if does nto exist then fore sure we need to add hashset
                    // using hashset so that wee can remove what we want to remove
                    map.put(mat[i][j], new HashSet<Cell>());
                    map.get(mat[i][j]).add(new Cell(i, j));
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Arrays.stream("hello how are you".split(" ")).forEach(s -> list.add(s));

        Iterator<String> it = list.iterator();
        ListIterator<String> lit = list.listIterator();

        while (it.hasNext()) {
            String s = it.next();
            if (s.startsWith("a")) {
                it.remove();
            } else {
                System.out.println(s);
            }
        }
//        for(String s:list){
//            if(s.equals("hello")){
//                list.remove(s);
//            }
//        }
//
//        System.out.println(list);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("rajat");
        hashSet.add("hello");
        hashSet.add("o");

        Iterator<String> hit = hashSet.iterator();
        while (hit.hasNext()){
            String val = hit.next();
            if(val.equals("o")){
            //    hit.remove();
                hashSet.remove(val);
            }
        }
        System.out.println(hashSet);
        // {here}

//        while (lit.hasNext()) {
//            String s = lit.next();
//            if (s.startsWith("a")) {
//                lit.set("1111" + s);
//            } else {
//                System.out.println(s);
//            }
//        }

        System.out.println(list);
}
}
