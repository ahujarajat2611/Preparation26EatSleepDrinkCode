package zrzahid;

import java.util.Arrays;

/**
 * Created by hadoop on 9/9/17.
 */
public class MinHeap {
    private int capacity = 10;
    private int size = 0;
    int [] items = new int[capacity];
    private int getLeftIndex(int i){ return 2*i+1;}
    private int getRightIndex(int i){return 2*i+2;}
    private int getParentIndex(int i){return (i-1)/2;}
    private int getParent(int i){return items[getParentIndex(i)];}
    private int getLeftChild(int i){return items[getLeftIndex(i)];}
    private int getRightChild(int i){return items[getRightIndex(i)];}

    private boolean hasLeftChild(int i){return getLeftIndex(i)<=size-1;}
    private boolean hasRightChild(int i){return getRightIndex(i)<=size-1;}
    private boolean hasParent(int i){return getParentIndex(i)>=0;}


    private int getSize(){return size;}

    private void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items,capacity*2);
            capacity = capacity*2;
        }
    }
    public int peek(){
        if(size == 0) return -1;
        return items[0];
    }
    public int  poll(){
        // copy last size-1 value to top
        // then reduce size by 1
        // then heapifydown from that zeroth index
        // return that value at zero copied
        if(size ==0) return -1;
        int value =  items[0];
        items[0] = items[size-1];
        size = size-1;
        heapifyDown();
        return value;
    }

    // almost same construct ..


    // almost sure that heapify down from top
    private void heapifyDown() {
        // here  startinng from top
        int index = 0;
        while (hasLeftChild(index)){
            int smallerChildIndex = getLeftIndex(index);
            if(hasRightChild(index) && getRightChild(index)<getLeftChild(index)){
                smallerChildIndex = getRightIndex(index);
            }

            if(items[smallerChildIndex]<items[index]){
                swap(index,smallerChildIndex);
                index = smallerChildIndex;
            }
            else {
                break;
            }
        }

    }
    // heapiffy up starts frm lower most column which is size -1
    private void heapifyUp(){
        int index = size-1;
        while (hasParent(index)){
            if(getParent(index)<items[index]){
                break;
            }
            else{
                swap(getParentIndex(index),index);
                index = getParentIndex(index);
            }

        }

    }

    private void swap(int parentIndex, int index) {
        int temp = items[parentIndex];
        items[parentIndex] = items[index];
        items[index] = temp;
    }

    public void add(int val){
        ensureCapacity();
        items[size] = val;
        size++;
        heapifyUp();
    }


}
/**
 * Created with IntelliJ IDEA.
 * User: Gong Li
 * Date: 5/26/13
 * Time: 12:23 PM
 * Implement a priority queue using a heap
 * The heap is implemented using an row indexed from 1
 */
class PriorityQueueUsingHeap<T extends Comparable<T>> {
    T[] arr;
    int N;

    public static void main(String[] args) {
        PriorityQueueUsingHeap<Integer> pq = new PriorityQueueUsingHeap<Integer>();
        pq.insert(3);
        System.out.println(pq.toString());
        pq.insert(5);
        System.out.println(pq.toString());
        pq.insert(2);
        System.out.println(pq.toString());
        pq.insert(-1);
        System.out.println(pq.toString());
        pq.insert(9);
        System.out.println(pq.toString());
        pq.insert(4);
        System.out.println(pq.toString());

        pq.delMax();
        System.out.println(pq.toString());
        pq.delMax();
        System.out.println(pq.toString());
        pq.delMax();
        System.out.println(pq.toString());
        pq.delMax();
        System.out.println(pq.toString());
        pq.delMax();
        System.out.println(pq.toString());
    }

    public PriorityQueueUsingHeap(){
        arr = (T[]) new Comparable[2];
        N = 0;
    }

    public void insert(T t){
        if (N == arr.length - 1) resize(2*N + 1);
        arr[++N] = t;
        swim(N);
    }

    public T delMax(){
        if (isEmpty()) return null;
        T t= arr[1];
        exch(1,N--);
        arr[N+1] = null;
        sink(1);

        //resize this row
        if (N == (arr.length -1)/4) resize((arr.length-1) / 2 + 1);
        return t;
    }
    //helper methods
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= N; i ++)
            sb.append(arr[i].toString()+" ");
        return sb.toString();
    }

    private boolean isEmpty(){
        return N == 0;
    }
    private void resize(int capacity){
        T[] copy = (T[]) new Comparable[capacity];
        for(int i = 1; i <= N; i ++ )
            copy[i] = arr[i];
        arr = copy;
    }

    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k < N){
            int j = 2 * k;
            if(j < N && less(j, j +1)) j = j + 1;
            if(less(j, k)) break;
            exch(k,j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        if (arr[i].compareTo(arr[j]) < 0)
            return true;
        return false;
    }

    private void exch(int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
