package BasicAlgorithms.LinkedList;

/**
 * Created by hadoop on 19/12/17.
 */
public class SortList {
    // make sure you define functions such a way that you can break down tasks and send it toitself for other tasks to do
    // define function signtatur such taht i will ask recursion to odo small tasks and keep gather the answers from recutrrion left
    // and right !!
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode left = head;
        ListNode right = walker.next;
        //First break the list, then merge together
        walker.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
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
        } else {
            head.next = right;
        }
        return dummy.next;
    }
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
}
