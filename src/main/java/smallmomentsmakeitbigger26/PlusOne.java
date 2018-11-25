package smallmomentsmakeitbigger26;
import java.util.*;
/**
 * Created by hadoop on 14/12/17.
 */
public class PlusOne {
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // there is one very imp trick in this problem
    // reverse add 1 and then only lopp until value is more than 10
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        ListNode reversed = reverse(head);
        reversed.val++;
        ListNode current = reversed;
        while (current != null && current.val >= 10) {
            current.val -= 10;
            if (current.next == null) {
                current.next = new ListNode(1);
            } else {
                current.next.val++;
            }
            current = current.next;
        }
        reversed = reverse(reversed);
        return reversed;
    }

    public ListNode plusOneSimpler(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int carry = 1;
        while (!stack.isEmpty() && carry > 0) {
            curr = stack.pop();
            curr.val++;
            carry = curr.val / 10;
            curr.val %= 10;
        }
        if (carry > 0) {
            curr = new ListNode(1);
            curr.next = head;
            head = curr;
        }
        return head;
    }

    public ListNode plusOneSimplerMuch(ListNode head) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode current = dummy;
        ListNode beforeNine = dummy;
        while (current.next!=null) {
            if (current.next.val == 9) {
                current = current.next;
            } else {

                beforeNine = current.next;
                current = current.next;

            }
        }
        boolean newhead = false;
        if(beforeNine == dummy){
            newhead = true;
        }
        else{
            beforeNine.val = beforeNine.val+1;
        }
        while (beforeNine.next!=null ){
            beforeNine.next.val=0;
            beforeNine = beforeNine.next;
        }

        if(newhead){
            return dummy;
        }

        return dummy.next;
    }
}
/*
    public ListNode plusOne(ListNode head) {
        ListNode newHead = reverse(head);
        ListNode cur = newHead;
        ListNode prev = null;
        int carry = 1;

        while (cur != null) {
            int sum = carry + cur.val;
            cur.val = sum % 10;
            carry = sum / 10;
            prev = cur;
            cur = cur.next;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        }
        newHead = reverse(newHead);

        return newHead;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
 */
/*

public class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int carry = 1;
        while (!stack.isEmpty() && carry > 0) {
            curr = stack.pop();
            curr.val++;
            carry = curr.val / 10;
            curr.val %= 10;
        }
        if (carry > 0) {
            curr = new ListNode(1);
            curr.next = head;
            head = curr;
        }
        return head;
    }
}


 */
