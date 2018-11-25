package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class IntersectionLinkedListNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int countA = 0;
        int countB = 0;
        int diff = 0;
        ListNode node = headA;
        while (node != null) {
            countA++;
            node = node.next;
        }
        node = headB;
        while (node != null) {
            countB++;
            node = node.next;
        }
        diff = Math.abs(countA - countB);
        node = (countA > countB) ? headA : headB;
        while (diff != 0) {
            diff--;
            node = node.next;
        }
        ListNode nodeA = (countA > countB) ? node : headA;
        ListNode nodeB = (countA > countB) ? headB : node;
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return null;
    }
}
