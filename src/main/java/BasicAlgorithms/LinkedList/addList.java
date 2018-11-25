package BasicAlgorithms.LinkedList;

public class addList {
    //考虑越界问题
    public ListNode addLists(ListNode l1, ListNode l2) {
        int curry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + curry;
            ListNode n = new ListNode(sum%10);
            p.next = n;
            p = p.next;
            curry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + curry;
            ListNode n = new ListNode(sum%10);
            p.next = n;
            p = p.next;
            curry = sum/10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + curry;
            ListNode n = new ListNode(sum%10);
            p.next = n;
            p = p.next;
            curry = sum/10;
            l2 = l2.next;
        }
        // if carry is more till last then for sure
        // there we need to addd another node at the end //
        // mind you list in invrted
        if (curry > 0) {
            p.next = new ListNode(curry);
        }
        return dummy.next;
    }
}
