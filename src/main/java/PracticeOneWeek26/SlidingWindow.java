package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 10/12/17.
 */
public class SlidingWindow {
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
            if(i>=k) {
                remove(nums[i - k]);
            }
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
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k < 0) {
            return rst;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        for (int i = k; i < nums.length; i++) {
            rst.add(nums[deque.peekFirst()]);
            // if polled first lesss than i-k just remove it fuck ...
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        //Last move's result needs to be recorded:
        rst.add(nums[deque.peekFirst()]);
        return rst;
    }

}
