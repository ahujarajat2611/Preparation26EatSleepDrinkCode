package BasicAlgorithms.Paritition;

import java.util.Random;

class NBComparator {
      public int cmp(String a, String b){
          return 0;
      }
}

/**
 * public class NBComparator {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
 */

public class Solution {
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null){
            return;
        }
        if (nuts.length != bolts.length || nuts.length == 0){
            return;
        }
        shuffle(nuts);
        shuffle(bolts);
        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }

    public void qsort(String[] nuts, String[] bolts, NBComparator compare, int lo, int hi){
        if (lo >= hi){
            return;
        }
        String pivot = nuts[lo];
        int index = partition(bolts, pivot, lo, hi, compare);
        // get partitioned index //
        // one more parititoning based ob bolts[index]
        // parittion one and then nbased on first parititon parittion seccond array ( good concept)
        partition(nuts, bolts[index], lo, hi, compare);



        qsort(nuts, bolts, compare, lo, index - 1);
        qsort(nuts, bolts, compare, index + 1, hi);
    }

    public int partition(String[] str, String pivot, int lo, int hi, NBComparator compare){
        String corr = null;
        for (int i = lo; i <= hi; i++){
            if (compare.cmp(str[i], pivot) == 0 || compare.cmp(pivot, str[i]) == 0){
                corr = str[i];
                String temp = str[i];
                str[i] = str[lo];
                str[lo] = temp;
                break;
            }
        }
        int left = lo;
        int right = hi;
        while(left < right){
            while(left < right && (compare.cmp(str[right], pivot) == 1 || compare.cmp(str[right], pivot) == 0 || compare.cmp(pivot, str[right]) == -1 || compare.cmp(pivot, str[right]) == 0)){
                right--;
            }
            str[left] = str[right];
            while(left < right && (compare.cmp(str[left], pivot) == -1 || compare.cmp(str[left], pivot) == 0 || compare.cmp(pivot, str[left]) == 1 || compare.cmp(pivot, str[left]) == 0)){
                left++;
            }
            str[right] = str[left];
        }
        str[left] = corr;
        return left;
    }

    public void shuffle(String[] str){
        Random random = new Random();
        int n = str.length;
        for (int i = 0; i < n; i++){
            int r = i + random.nextInt(n - i);
            String temp = str[i];
            str[i] = str[r];
            str[r] = temp;
        }
    }
}