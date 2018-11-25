package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
import java.util.*;
public class SlidingWindowMedian {
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

        // using premedian logic foor that one element has to be in the heap
        for (int i = 1; i < k; i++) {
            add(nums[i]);
        }


        // see if you can avoiid working with index .. do that
        // and define api which does nt involve indexex problem
        // coulld be the case that you need to hhave indexed then inly play with arrays
        // like here if you have to define array it woul dbe int arrya[nums.lengtj-k+1];

        rst.add(maxHeap.peek());
        for (int i = k; i < nums.length; i++) {
            // since its not stream .. sliding we need to remove elements as well
            // thats how we can deal with it !!!
            // we need to maintain maxheap+minheap size equal to K always ssssss
            // in stream keep adding no giives shit .. here is sliding !!!
            remove(nums[i - k]);
            add(nums[i]);
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
        // if we know that val is more than
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

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        System.out.println(slidingWindowMedian.medianSlidingWindow(new int[]{3,4,1,3,5,5,},3));
    }

}
