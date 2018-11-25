package BasicAlgorithms.SlidingWindow;

import BasicAlgorithms.Array.AVLTree;

import java.util.PriorityQueue;

/**
 * Created by hadoop on 26/1/18.
 */
public class SortKsortedArray {
    public void sortKSortedArrayUsingAvl(int a[], int n, int k) {
        AVLTree tree = new AVLTree();
        for (int i = 0; i < k; i++) {
            tree.root = tree.insert(tree.root, a[i]);
        }
        int val, j = 0;
        for (int i = k; i < n; i++) {
            val = tree.findMin(tree.root).data; // find logn
            a[j++] = val;
            tree.root = tree.delete(tree.root, val); // delete logn
            tree.root = tree.insert(tree.root, a[i]); // insert logn
        }
        for (int i = 0; i < k; i++) {
            val = tree.findMin(tree.root).data; //
            a[j++] = val;
            tree.root = tree.delete(tree.root, val);
        }
    }

    public void sortKSortedArray(int a[], int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //MinHeap<Integer> minHeap = new MinHeap<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(a[i]);
        }
        int val, j = 0;
        for (int i = k; i < n; i++) {
            val = minHeap.poll(); // find o1
            a[j++] = val;
            minHeap.add(a[i]); // addd logn
        }
        for (int i = 0; i < k; i++) {
            val = minHeap.poll();
            a[j++] = val;
            //minHeap.remove();
        }
    }
}
