package BasicAlgorithms.LinkedList;

/**
 * Created by hadoop on 19/12/17.
 */
public class ReverseLinkedList {
    //Recusion method
    public ListNode reverseRecrusion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return helper(null, head);
    }
    private ListNode helper(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode head = helper(cur, cur.next);
        cur.next = pre;
        return head;
    }


    private ListNode helperMine(ListNode pre, ListNode cur) {
        if(cur == null){
            return pre;
        }
        ListNode save = cur.next;
        cur.next = pre;
        return helperMine(cur,save);
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode out = reverseLinkedList.helperMine(null,listNode);
        while (out!=null){
            System.out.println(out.val);
            out = out.next;
        }
    }

    }
