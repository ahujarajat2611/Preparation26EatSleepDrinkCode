package DSA.Backtracking;

import BasicAlgorithms.utils.ConsoleWriter;
import DSA.Common.CommonUtil;

/**
 * Created by hadoop on 21/2/18.
 */
public class PermutationsUnique {
    public void permuationsUnique(char a[], int start) {
        if (start == a.length) {
            ConsoleWriter.printArray(a);
        }
        for (int j = start; j < a.length; j++) {
            // here we are trying to swapa i and j so first check if we have already swapped a[j] to current posititon
            //so check first from I to j-1 if a[j] exists .. just wow !!!
            if (!containsDuplicate(a, start, j - 1, a[j])) {
                CommonUtil.swap(a, start, j);
                permuationsUnique(a, start + 1);
                CommonUtil.swap(a, start, j);
            }
        }
    }

    private boolean containsDuplicate(char[] a, int start, int end, int k) {
        for (int i = start;	 i <= end; i++) {
            if (a[i] == k)
                return true;
        }
        return false;
    }
    public void permuations(char[] a, int l, int r) {
        if (l == r) {
            ConsoleWriter.printArray(a);
        } else {
            for (int i = l; i <= r; i++) {
                CommonUtil.swap(a, i, l);
                permuations(a, l + 1, r);
                CommonUtil.swap(a, i, l);
            }
        }

    }

    public void permuationsOfLengthK(char[] a, int start, int k) {
        if (start == k) {
            for (int i = 0; i < k; i++)
                System.out.print(a[i] + "");
            System.out.print(" ");
            return;
        }

        for (int i = start; i < a.length; i++) {
            CommonUtil.swap(a, i, start);
            permuationsOfLengthK(a, start + 1, k);
            CommonUtil.swap(a, i, start);
        }

    }
    public void permuations(char a[], int start) {
        if (start == a.length) {
            ConsoleWriter.printArray(a);
        }
        for (int j = start; j < a.length; j++) {
            CommonUtil.swap(a, start, j);
            permuations(a, start + 1);
            CommonUtil.swap(a, start, j);
        }
    }

    public static void main(String[] args) {
        PermutationsUnique permutationsUnique = new PermutationsUnique();
        permutationsUnique.permuationsOfLengthK(new char[]{'a','b','c'},0,2);
    }
}
