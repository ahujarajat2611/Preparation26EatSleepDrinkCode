package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        while (head != slow.next) {
            slow = slow.next;
            head = head.next;
        }

        return head;
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;

            if (runner == walker)
                return true;
        }
        return false;
    }

}
