package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
/*
1 billion bits is 100 mb
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null)
                return null;
            if (m == n)
                return head;

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            int index = 1;
            ListNode prelabel = dummy;
            for (index = 1; index < m; index++)
            {
                prelabel = head;
                head = head.next;
                if (head == null)
                    return null;
            }
            ListNode prev = head;
            ListNode label = head;
            head = head.next;
            //index ++;
            for (index = m + 1; index <= n; index++)
            {
                label.next = head.next;
                prelabel.next = head;
                head.next = prev;
                prev = head;
                head = label.next;
            }
            return dummy.next;
        }
    }
}
