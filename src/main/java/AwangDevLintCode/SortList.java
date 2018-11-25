package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
public class SortList {

/*
    Recap:12.09.2015. practice merge sort
Thinking process:
1.Divide and conquer
2. can use merge sort or quick sort. Used merge sort here.
3. Find middle
4. Sort each side recursively.
5. merge function.
Note: when checking null, node != null should be in front of node.next != null. Because if node is alreay null, node.next gives exception.

*/
public ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null) {
            head.next = left;
        } else if (right != null){
            head.next = right;
        }
        return dummy.next;
    }

    /*
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode left = sortList(mid.next);
        mid.next = null;
        ListNode right = sortList(head);
        return merge(left, right);
    }

}
