package DSA.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 11/2/18.
 */
public class InterleaveQueueFirstHalfSecondHalf {
    public void interleavingQueueWithTwoStacks(Deque<Integer> q) {
        int n = q.size();
        Queue<Integer> tq = new LinkedList<>();

        for (int i = 0; i < n / 2; i++) {
            tq.offer(q.removeFirst());
        }
        //System.out.println(tq);
        for (int i = n / 2; i < n; i++) {
            if (!tq.isEmpty())
                q.addLast(tq.poll());
            q.addLast(q.removeFirst());
        }
    }
    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<Integer>();
        q.addLast(10);
        q.addLast(20);
        q.addLast(30);
        q.addLast(40);
        q.addLast(50);
        q.addLast(60);
        q.addLast(70);
        q.addLast(80);
        q.addLast(90);
        InterleaveQueueFirstHalfSecondHalf obj = new InterleaveQueueFirstHalfSecondHalf();

       // obj.print(q);
        // Time : O(n), Space : O(n)
        obj.interleavingQueueWithTwoStacks(q);
        while (!q.isEmpty()){
            System.out.println(q.removeFirst());
        }
       // obj.print(q);
    }
}
