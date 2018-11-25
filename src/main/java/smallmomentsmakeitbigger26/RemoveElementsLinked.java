package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class RemoveElementsLinked {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode curr = fakeHead;

        while (curr.next != null){
            if(curr.next.val == val){
                // simple just ignroe that has same vlaue as vla
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        return fakeHead.next;
    }
}