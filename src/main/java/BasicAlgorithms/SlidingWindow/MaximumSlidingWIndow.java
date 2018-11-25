package BasicAlgorithms.SlidingWindow;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.*;

/**
 * Created by hadoop on 21/10/17.
 */
public class MaximumSlidingWIndow {


    public int[] maxSlidingWindowMine(int[] nums, int k) {

        TreeMap<Integer,Integer> window = new TreeMap<Integer,Integer>();

        for(int i=0;i<k;i++){
            window.put(nums[i],window.getOrDefault(nums[i],0)+1);
        }

        int res[] = new int[nums.length-k+1];
        if(nums.length ==0){
            return new int[]{};
        }
        if(k ==0 ){
            return res;
        }
        int index =0;
        for(int p = k;p<nums.length;p++){
            res[index++] = window.lastEntry().getKey();
            remove(window,nums[p-k]);
            window.put(nums[p],window.getOrDefault(nums[p],0)+1);
        }
        res[index] = window.lastEntry().getKey();
        return res;
    }

    private void remove(TreeMap<Integer, Integer> window, int num) {
        int count = window.get(num);
        count = count-1;
        if(count==0){
            window.remove(num);
        }
        else {
            window.put(num,count);
        }
    }

    public static void main(String[] args) {
        MaximumSlidingWIndow maximumSlidingWIndow = new MaximumSlidingWIndow();
        int []ar = {-7,-8,7,5,7,1,6,0};
        int k =4;
        ConsoleWriter.printArray(maximumSlidingWIndow.maxSlidingWindowMine(ar,k));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] returnedAns = new int[len - k + 1]; // no of windows of length k
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // another way to implement is

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        returnedAns[0] = pq.peek();
        for (int i = k; i < nums.length; i++) {
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            returnedAns[i - k + 1] = pq.peek();
        }

        return returnedAns;


//        for(int i=0;i<nums.length;i++){
//            if(i<k-1){
//                pq.add(nums[i]);
//            }
//            else {
//                pq.add(nums[i]);
//                returnedAns[i-k] = pq.peek();
//                pq.remove(nums[i-(k-1)]);
//            }
//        }
//        return returnedAns;

    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> deque= new ArrayDeque<Integer>();

        int [] returnedAns = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            // remove elements frm window
            if(i>=k) {
                if (!deque.isEmpty() && nums[deque.peekFirst()] <i-k+1){
                    deque.removeFirst();
                }
            }
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i>=k-1)
            returnedAns[i-k+1] =nums[deque.peekFirst()];
        }
        return returnedAns;
    }


    private class Solution {

        /**
         * Keep monotonic deque: containing index, and nums[index] is monotonic in
         * deque peek element is the index of the max number in current sliding
         * window and the numbers that indices in this deque represents are in
         * non-ascending order
         * */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n == 0) {
                return new int[]{};
            }
            int[] res = new int[n - k + 1];
            // peek element is the index of the max number in current sliding window
            // and the numbers that indices in this deque represents are in non-ascending order
            Deque<Integer> descendIndices = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                //define window and move accrodingly things easier to work for index
                int window = i - k + 1;
                // poll elements out of current window
                while (!descendIndices.isEmpty() && descendIndices.peekFirst() < i - k + 1) {
                    descendIndices.removeFirst();
                }
                // build descending indices
                while (!descendIndices.isEmpty() && nums[descendIndices.peekLast()] < num) {
                    descendIndices.removeLast();
                }
                descendIndices.addLast(i);
                if (window >= 0) {
                    res[window] = nums[descendIndices.peekFirst()];
                }
            }
            return res;
        }
    }
}