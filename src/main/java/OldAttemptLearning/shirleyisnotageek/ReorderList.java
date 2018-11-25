package OldAttemptLearning.shirleyisnotageek;
/*
Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

The main purpose of this post is that I always have a problem with reverse linked list.

To reverse a list:
1. initialize a new node, newHead.
2. point the head to newHead.
3. let newHead be head.
4. go to the next node.

This is indeed an easy problem.

1. find middle node.
2. reverse the list.
3. merge the list.

 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode mid = findMiddle(head);
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        merge(head, head2);
         
    }
    private void merge(ListNode head, ListNode head2) {
        ListNode node = new ListNode(0);
        int index = 0;
        while (head != null && head2 != null) {
            if (index % 2 == 0) {
                node.next = head;
                head = head.next;
            }
            else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
            index++;
        }
        if (head != null) 
            node.next = head;
        else
            node.next = head2;
    }
    private ListNode reverse(ListNode head) {
         ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}