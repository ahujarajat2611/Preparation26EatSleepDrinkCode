package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;

        merge(head, tail);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode reversedList = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = reversedList;
            reversedList = head;
            head = temp;
        }
        return reversedList;
    }

    private void merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        int index = 0;
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index += 1;
        }
        if (head1 != null) {
            dummy.next = head1;
        } else if (head2 != null) {
            dummy.next = head2;
        }
    }

    private ListNode mergeRecursive(ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        head1.next = mergeRecursive(head2, head1.next);
        return head1;
    }
    public static void main(String args[]){
        ReorderList reorderList = new ReorderList();
        ListNode listNode1 = new ListNode(1);
        listNode1.next  = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(5);
        listNode2.next  = new ListNode(6);
        listNode2.next.next = new ListNode(7);
        listNode2.next.next.next = new ListNode(8);
        listNode1 = reorderList.mergeRecursive(listNode1,listNode2);
       // reorderList.print(listNode1);
        //System.out.println(listNode1.val);
        //System.out.println(listNode1.next.val);
        ListNode listNode3 = new ListNode(1);
        listNode3.next  = null;
        //listNode3.next.next = null;
        reorderList.print(reorderList.deleteDuplicatesAgainWithDISTINCTELEMTNONLY(listNode3));
    }


    void print(ListNode node){
        System.out.println("print");
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode parent = dummy;
        ListNode current = head;

        while(parent.next!=null){
            int val = parent.next.val;
            //System.out.println(parent.next);
            //System.out.println(val);
            //System.out.println(parent.next.next.val);
            while(parent.next.next!=null && parent.next.next.val ==val){
                //System.out.println(parent.next.next.val);
                parent.next = parent.next.next;
                //System.out.println("enter");
            }
            parent = parent.next;
        }
        return dummy.next;

    }
    public ListNode deleteDuplicatesAgainWithDISTINCTELEMTNONLY(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode parent = dummy;
        ListNode current = head;
        ListNode prevParent = dummy;
        while(parent.next!=null && parent.next.next!=null){
            int val = parent.next.val;
            boolean flag = false;
            System.out.println("val"+val);
            while(parent.next.next!=null && parent.next.next.val ==val){
                System.out.println(parent.next.next.val);
                flag = true;
                parent.next = parent.next.next;
                System.out.println(parent.next);
            }
            if(flag){
                // prevParent.next = parent.next.next;
                // parent = parent.next.next;
            }
            else{
                System.out.println("not to ente");
                prevParent = parent;
                parent = parent.next;
            }
        }
        parent.next = null;
        return dummy.next;

    }
}
