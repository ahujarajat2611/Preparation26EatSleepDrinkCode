package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class DeletingDuplicatesLinkedListKeepingonlydistinct {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode parent = dummy;
        if(parent.next == null || parent.next.next == null){
            return dummy.next;
        }
        while(parent.next!=null && parent.next.next!=null){
            int val = parent.next.val;
            boolean flag = false;
            ListNode temp = parent.next;
            // to delete you need handle of parent and temp has parent handle
            while(temp.next!=null && temp.next.val ==val){
                temp = temp.next;
                flag = true;

            }
            if(flag){
                // found duplicates tmp is parent so move to its next
                parent.next = temp.next;
            }
            else{
                // no duplicates simply move fforward
                parent = parent.next;
            }
        }
        return dummy.next;

    }
    public ListNode deleteDuplicatesSimply(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode parent = dummy;
        ListNode current = head;

        while(parent.next!=null){
            int val = parent.next.val;
            ListNode temp = parent.next;
            while(temp.next!=null && temp.next.val == val){
                temp = temp.next;
            }
            // failed to meet conditions temp
            // always you use two pointer approach
            // this step is about tak one step back and look for anserwr
            // like end-1 temp
            parent.next = temp;
            parent = parent.next;
        }
        return dummy.next;

    }
}
