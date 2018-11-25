package BasicAlgorithms.SlidingWindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 21/9/17.
 */


// template
    /*
    first add number
    then remove if moving outside window
    // once removed then
     */
public class SlidingWindowMedian {

    List<Integer> slidingWindow(int []num, int k){
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        for(int i=0;i<num.length;i++){
            // add the number
            //if number if lower than max heap value than in max heap
            // rmeove the value from window /////
            if(maxHeap.isEmpty() || num[i]<maxHeap.peek()){
                maxHeap.add(num[i]);
            }
            else {
                minHeap.add(num[i]);
            }
            // remove the number
            // remove element ffrom window
            if(i>=k){
                if(num[i-k]>maxHeap.peek()){
                    minHeap.remove(num[i-k]);
                }
                else {
                    maxHeap.remove(num[i-k]);
                }
            }
            // rebalance the number
            if(maxHeap.size()-minHeap.size() >=2){
                minHeap.add(maxHeap.poll());
            }
            if(minHeap.size() -maxHeap.size() >=1){
                maxHeap.add(minHeap.poll());
            }
            //find the peek 
            if( i>=k-1 ){
                list.add(maxHeap.peek());
                System.out.println(maxHeap.peek());
            }
        }
        return list;
    }
    double[] setMedian(int []array){
        PriorityQueue<Integer> loweres = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return  -1*o1.compareTo(o2);
            }
        });
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        double[] median = new double[array.length];
        for( int i=0;i<array.length;i++){
            // here no removal only addition ... 
            addNumber(array[i],loweres,higher);
            balace(loweres,higher);
            median[i] = getMedian(loweres,higher);
        }
        return median;
    }

    private double getMedian(PriorityQueue<Integer> loweres, PriorityQueue<Integer> higher) {
            if(loweres.size() == higher.size()){
                return (loweres.peek() + higher.peek())/2;
            }
            return loweres.peek();
    }

    private void balace(PriorityQueue<Integer> maxheapOfLowersNumbers, PriorityQueue<Integer> minHeapOfHigherNumbers) {
        if(maxheapOfLowersNumbers.size()-minHeapOfHigherNumbers.size()>=2){
            minHeapOfHigherNumbers.add(maxheapOfLowersNumbers.poll());
        }
        if(minHeapOfHigherNumbers.size()-maxheapOfLowersNumbers.size()>=1){
            maxheapOfLowersNumbers.add(minHeapOfHigherNumbers.poll());
        }
    }

    private void addNumber(int i, PriorityQueue<Integer> loweres, PriorityQueue<Integer> higher) {
            if(loweres.isEmpty() || i<loweres.peek()){
                loweres.add(i);
            }
            else{
                higher.add(i);
            }
    }


    // straight forward solution to understand must see ..
    // simple fundaaaaa .. keep maxheapsie always more than 1  then addition check from premedian
    // which will me maxheap.peek() ..
   private  class Solution {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        /**
         * @param nums: A list of integers.
         * @return: The median of the element inside the window at each moving.
         */
        public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
            ArrayList<Integer> rst = new ArrayList<Integer>();
            if (nums == null || nums.length == 0 || k <= 0) {
                return rst;
            }
            minHeap = new PriorityQueue<Integer>();
            maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
                public int compare(Integer x, Integer y){
                    return y - x;
                }
            });
            maxHeap.offer(nums[0]);

            for (int i = 1; i < k; i++) {
                add(nums[i]);
            }

            rst.add(maxHeap.peek());
            for (int i = k; i < nums.length; i++) {
                add(nums[i]);
                remove(nums[i - k]);
                rst.add(maxHeap.peek());
            }
            return rst;
        }

        public void add(int val) {
            int preMedian = maxHeap.peek();
            if (val > preMedian) {
                minHeap.offer(val);
            } else {
                maxHeap.offer(val);
            }
            balance();
        }

        public void remove(int val) {
            int preMedian = maxHeap.peek();
            if (val > preMedian) {
                minHeap.remove(val);
            } else {
                maxHeap.remove(val);
            }
            balance();
        }

        public void balance() {
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

    }
}
