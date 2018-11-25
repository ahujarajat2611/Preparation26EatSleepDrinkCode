//package DSA.Ds;
//
///**
// * Created by hadoop on 11/2/18.
// */
//public class MaxHeap {
//    int heapSize;
//    int arr[];
//    int capacity;
//
//    MaxHeap(int capacity) {
//        this.capacity = capacity;
//        arr = new int[capacity];
//    }
//
//    public void heapfyDown(int i) {
//        //int largest;
//        //int l;
//        //int r;
//        while (leftChildExisit(i)) {
//            int largestValue = leftChild(i);
//            int largestIndex = leftChildIndex(i);
//            if (rightChildExist(i) && rightchild(i) > largestValue) {
//                largestValue = rightchild(i);
//                largestIndex = rightChildIndex(i);
//            }
//            if (largestValue < arr[i]) {
//                break;
//            } else {
//                swap(arr, i, largestIndex);
//                i = largestIndex;
//            }
//        }
//
//    public void build_heap(int a[]) {
//        arr = a;
//        this.heapsize = arr.length;
//        // non leaf nodes
//        for (int i = size / 2 - 1; i >= 0; i--) {
//            max_heapify(i);
//        }
//    }
//
//}
//
//    private void heapifyUp() {
//        int index = size -1;
//        while(hasParent(index)){
//            int getValue = getParent(index);
//            if(getValue > arr[index]){
//                break;
//            }
//            else {
//                swap(arr,index,getParentIndex(index)) ;
//                index = getParentIndex(index);
//
//            }
//        }
//    }
//}