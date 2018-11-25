package BasicAlgorithms.Heap;

/**
 * Created by hadoop on 7/1/18.
 */
public class Heapify {
    public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--){
            siftDown(A, i);
        }
    }

    public void siftDown(int[] A, int k){
        while(k < A.length){
            int smallestIndex = k;
            if (2 * k + 1 < A.length && A[2 * k + 1] < A[smallestIndex]){
                smallestIndex = 2 * k + 1;
            }
            if (2 * k + 2 < A.length && A[2 * k + 2] < A[smallestIndex]){
                smallestIndex = 2 * k + 2;
            }
            if (smallestIndex == k){
                return;
            }
            int temp = A[k];
            A[k] = A[smallestIndex];
            A[smallestIndex] = temp;
            k = smallestIndex;
        }
    }
}
