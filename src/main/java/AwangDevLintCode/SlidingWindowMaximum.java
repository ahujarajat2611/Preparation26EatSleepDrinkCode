package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
import java.util.*;
// there are questions
// arounc either maintaing decreasing list
// or increasing list
// and once we do that
// we add number
// advantable that top of that list gives me that ans taht we are loooking
// for efficienly that the trick you need to kepe in your mind !!!
/*

eITHER YOU MAKE INCREASING LIST OR DECREASING LIST
// MAX SLIDIIIN WINDOW MEANS NO BRAINER --> DECREASING LIST


HAD IT BEEN MIN SLIDING WINDOW
IT WUDHAVE BEEN INCREASING LIST
 */

public class SlidingWindowMaximum {
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k < 0) {
            return rst;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            // maitains decreasing list
            // LIKE STACK IF NUM[I] IS MORE THAN STACK.PEEK --- REMOVE IT
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        for (int i = k; i < nums.length; i++) {
            // Make sure first node is the answer not the last node !!1
            // you jst got confused !!

            rst.add(nums[deque.peekFirst()]);
            // if indexed at first is less than i-k then remove it then and
            // there itselffffff we no longer requitred this since for next peek
            // we want to remove this .. only thing i care about that that peek operation
            // should be before thr nexxt peeek first
            // even if you remove after adddition then also its fine !!!!
            //
            //usually in sliding window i have done
            /// if ( i>=k remove i-k ... so peek index is less than or equal to i-k remove it straight forward !!!!!
            /// we culd have used treeset to do the same thing !!!
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // in the end we have to push the current element !!!!

            deque.offerLast(i);
        }

        //Last move's result needs to be recorded:
        rst.add(nums[deque.peekFirst()]);
        return rst;
    }
}
