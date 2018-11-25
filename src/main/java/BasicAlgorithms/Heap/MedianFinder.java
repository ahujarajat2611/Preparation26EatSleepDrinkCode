package BasicAlgorithms.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 5/9/17.
 */
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Collections.<Integer>reverseOrder());
        //maxheap has lower set of numbers

        minHeap = new PriorityQueue<>();
    }

    // add to max heap and then min heap
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            System.out.println("coming here since equal");
            System.out.println(maxHeap.peek());
            System.out.println(minHeap.peek());
            return ((double)(maxHeap.peek()+minHeap.peek()))/2;
        }
        System.out.println("coming here" +maxHeap.size());
        System.out.println("coming here" +minHeap.size());

        return maxHeap.peek();
    }
    public static void main(String args[]){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("mediain"+medianFinder.findMedian());
    }
}