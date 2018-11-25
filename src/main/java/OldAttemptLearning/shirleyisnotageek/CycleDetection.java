package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
public class CycleDetection {
  /*  Now here is the problem, what if we need to find where the cycle begins? By using the former method, it is highly possible that the two nodes meet inside the cycle, so what to do next?
    Let's review a little bit math.
    Let X be the number of nodes outside the cycle (assume there is one),
     so X = number of all the O's in the graph.
    Let Y be the number of nodes inside the cycle, so
    Y = number of all the P's (why did I use P not C? -_-|||).
    Let m be the node at which fast and slow meet,
    let s be the publish point of the cycle, then
    let K = m - s + 1, which is the number of nodes
     from the beginning of the cycle to the meeting point.
     Let steps be number of steps each node traverses before they meet.
    fast: X + mY + K = 2steps  (1)
    slow: X + nY + K = steps    (2)
    substitute (2) to (1), and we have
            X = (m - 2n)Y - K
    since Y is a cycle, m, n can be any integer, let m - 2n = 1

    X = Y - K, which means, after two nodes meet, the number of steps the slow node need to traverse before return to the publish point of the cycle equals number of nodes outside the cycle. This means we can let the head do some exercise with the slow node and, problem solved!
*/
  public ListNode detectCycle(ListNode head) {
      if (head == null)
          return null;
      ListNode fast = head;
      ListNode slow = head;
      while (fast != null && fast.next != null)
      {
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow)
              break;
      }
      if (fast == null || fast.next == null)
          return null;
      while (head != null)
      {
          if (head == slow)
              break;
          head = head.next;
          slow = slow.next;
      }
      return head;

  }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null)
        {
            if (fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;

    }
}
