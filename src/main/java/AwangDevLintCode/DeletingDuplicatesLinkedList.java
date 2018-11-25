package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class DeletingDuplicatesLinkedList {
    // sorted list given !!!
    public ListNode deleteDuplicatesSimply(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode parent = dummy;
        ListNode current = head;


        // Two pointer approach to delete things .. also looks very nice
        while(parent.next!=null){
            int val = parent.next.val;
            ListNode temp = parent.next;
            while(temp.next!=null && temp.next.val == val){
                temp = temp.next;
            }
            parent.next = temp;
            parent = parent.next;
        }
        return dummy.next;

    }
//*

    // in removing things two mantra
    // keep in parent pointers rather than
    // going to that pointer
    // // two pointer approach safe and kind a easy to use
    // in difficult quesitons
    // else this approach also would work !!

    //
    public void removeDuplicatesInSortedList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // one pointer approach also looks nice
        // can be extended for general purpose deletion !!!!!

        while (head.next != null) {
            if (head.next.val == head.val)
                head.next = head.next.next;
            else
                head = head.next;
        }
    }


    public void removeDuplicatesInUnsortedList(ListNode root) {
        if (root == null || root.next == null)
            return;
        ListNode cur1, cur2;
        cur1 = root;
        while (cur1 != null && cur1.next != null) {
            cur2 = cur1;
            while (cur2.next != null) {
                if (cur1.val == cur2.next.val)
                    cur2.next = cur2.next.next;
                else
                    cur2 = cur2.next;
            }
            cur1 = cur1.next;
        }
    }
}
