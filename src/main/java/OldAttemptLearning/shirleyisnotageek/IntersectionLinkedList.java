package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
public class IntersectionLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null)
                return null;
            int sizeA = getSize(headA);
            int sizeB = getSize(headB);
            int diff = Math.abs(sizeA - sizeB);
            int index = 0;
            if (sizeA > sizeB)
            {
                while (headA != null && index < diff)
                {
                    headA = headA.next;
                    index++;
                }
            }
            else
            {
                while(headB != null && index < diff)
                {
                    headB = headB.next;
                    index++;
                }
            }
            while (headA != null && headB != null)
            {
                if (headA.val == headB.val && headA.next == headB.next)
                    return headA;
                headA = headA.next;
                headB = headB.next;
            }
            return null;


        }
        private int getSize(ListNode head)
        {
            int size = 0;
            while (head != null)
            {
                size++;
                head = head.next;
            }
            return size;
        }
    }
}
