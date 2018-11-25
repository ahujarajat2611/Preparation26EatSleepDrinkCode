package DSA.Sorting;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.TreeSet;
import java.util.*;
/**
 * Created by hadoop on 11/2/18.
 */
public class SortKSortedArray {
    // Time : O(nlogk), Space : O(k)
    public void sortKSortedArrayUsingAvl(int a[], int n, int k) {
        //AVLTree tree = new AVLTree();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            set.add(a[i]);
            //tree.root = tree.insert(tree.root, a[i]);
        }
        int val, j = 0;
        for (int i = k; i < n; i++) {
            val = set.first();
            System.out.println("val"+val);
            //val = tree.findMin(tree.root).data;
            a[j++] = val;
            set.remove(val);
            set.add(a[i]);
            //tree.root = tree.delete(tree.root, val);
            //tree.root = tree.insert(tree.root, a[i]);
        }
        for (int i = 0; i < k; i++) {
            val = set.first();
            System.out.println("val"+val);
            a[j++] = val;
            set.remove(val);
           //tree.root = tree.delete(tree.root, val);
        }
    }
    public static void main(String args[]){
        SortKSortedArray so = new SortKSortedArray();
        int array[] = {2, 6, 3, 12, 56, 8};
        so.sortKSortedArrayUsingAvl(array,array.length,3);
        //System.out.println(array);
        ConsoleWriter.printIntArray(array);
    }
    public void sortKSortedArray(int a[], int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(a[i]);
        }
        int val, j = 0;
        for (int i = k; i < n; i++) {
            val = minHeap.peek();
            a[j++] = val;
            minHeap.poll();
            minHeap.add(a[i]);
        }
        for (int i = 0; i < k; i++) {
            val = minHeap.peek();
            a[j++] = val;
            minHeap.poll();
        }
    }
}
