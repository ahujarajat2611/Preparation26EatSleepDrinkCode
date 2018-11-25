package BasicAlgorithms.QuickSelect;

import java.util.Comparator;

/**
 * Created by hadoop on 25/2/18.
 */
public class NutsBolts {
    public class Solution {
//        /**
//         * @param nuts: an array of integers
//         * @param bolts: an array of integers
//         * @param compare: a instance of Comparator
//         * @return: nothing
//         *
//         */
////        private Comparator NBComparator = new Comparator() {
////            @Override
////            public int compare(Object o1, Object o2) {
////                return 0;
////            }
////        };
        class NBComparator implements Comparator{
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        }
        public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
            if (nuts == null || bolts == null) return;
            if (nuts.length != bolts.length) return;

            qsort(nuts, bolts, compare, 0, nuts.length - 1);
        }

        private void qsort(String[] nuts, String[] bolts, NBComparator compare,
                           int l, int u) {
            if (l >= u) return;
            // find the partition index for nuts with bolts[l]
            int part_inx = partition(nuts, bolts[l], compare, l, u);
            // partition bolts with nuts[part_inx]
            partition(bolts, nuts[part_inx], compare, l, u);
            // qsort recursively
            qsort(nuts, bolts, compare, l, part_inx - 1);
            qsort(nuts, bolts, compare, part_inx + 1, u);
        }

        private int partition(String[] str, String pivot, NBComparator compare,
                              int l, int u) {
            for (int i = l; i <= u; i++) {
                if (compare.compare(str[i], pivot) == 0 ||
                        compare.compare(pivot, str[i]) == 0) {
                    swap(str, i, l);
                    break;
                }
            }
            String now = str[l];
            int left = l;
            int right = u;
            while (left < right) {
                while (left < right &&
                        (compare.compare(str[right], pivot) == -1 ||
                                compare.compare(pivot, str[right]) == 1)) {
                    right--;
                }
                str[left] = str[right];

                while (left < right &&
                        (compare.compare(str[left], pivot) == 1 ||
                                compare.compare(pivot, str[left]) == -1)) {
                    left++;
                }
                str[right] = str[left];
            }
            str[left] = now;

            return left;
        }

        private void swap(String[] str, int l, int r) {
            String temp = str[l];
            str[l] = str[r];
            str[r] = temp;
        }
    }
}
