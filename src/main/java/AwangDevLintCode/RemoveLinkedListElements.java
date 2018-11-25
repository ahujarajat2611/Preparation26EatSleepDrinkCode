package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode parent = new ListNode(0);
        parent.next = head;
        ListNode dummy = parent;
        while (head != null) {
            if (head.val == val) {
                parent.next = head.next;
            } else {
                parent = parent.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode removeAllNodesOfData(ListNode root, int data) {
        if (root == null)
            return root;
        ListNode cur, head;
        head = new ListNode(0);
        head.next = root;
        cur = head;
        while (cur.next != null) {
            if (cur.next.val == data)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head.next;
    }
}
