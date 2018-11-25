package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newList = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = newList;
            newList = head;
            head = temp;
        }
        return newList;
    }

}
