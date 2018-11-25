package BasicAlgorithms.Sort;

/**
 * Created by hadoop on 24/10/17.
 */
class NBComparator {
    int cmp(String a,String b){
        return 1;
    }
}

public class NutsBolts {
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || bolts == null || nuts.length != bolts.length) {
            return;
        }
        quicksort(nuts, bolts, 0, nuts.length - 1, compare);
    }

    public void quicksort(String[] nuts, String[] bolts, int start, int end, NBComparator compare) {
        if (start >= end) {
            return;
        }
        int pivot = sortBolts(nuts[start], bolts, start, end, compare);
        sortNuts(nuts, bolts[pivot], start, end, compare);
        quicksort(nuts, bolts, start, pivot - 1, compare);
        quicksort(nuts, bolts, pivot + 1, end, compare);
    }

    public int sortBolts(String nut, String[] bolts, int start, int end, NBComparator compare) {
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && compare.cmp(nut, bolts[left]) < 0) {
                left++;
            }
            while (left < right && compare.cmp(nut, bolts[right]) > 0) {
                right--;
            }

            if (left < right) {
                swap(bolts, left, right);
            }
        }
        return left;
    }

    private void sortNuts(String[] nuts, String bolt, int start, int end, NBComparator compare){
        int left = start;
        int right = end;

        while(left < right){
            while(left < right && compare.cmp(nuts[left], bolt) > 0){
                left++;
            }
            while(left < right && compare.cmp(nuts[right], bolt) < 0){
                right--;
            }
            if(left < right) {
                swap(nuts, left, right);
            }
        }
    }
    public void swap(String[] s, int i, int j) {
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}