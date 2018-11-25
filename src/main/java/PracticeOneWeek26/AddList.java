package PracticeOneWeek26;

import java.util.Stack;

/**
 * Created by hadoop on 7/12/17.
 */
public class AddList {
    public ListNode addLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        Stack<ListNode> result = new Stack<ListNode>();
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();

        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        int carrier = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum = 0;
            if (!s1.isEmpty() && !s2.isEmpty()) {
                sum += s1.pop().val + s2.pop().val;
            } else if (!s1.isEmpty()) {
                sum += s1.pop().val;
            } else {
                sum += s2.pop().val;
            }
            result.push(new ListNode((sum + carrier) % 10));//2, 1, 9
            carrier = (sum + carrier) / 10; // 12/10 = 1; 11/10 = 1; (8+1)/ 10 = 0
        }
        if (carrier == 1) {
            result.push(new ListNode(carrier));
        }

        //return results:
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        while (!result.isEmpty()) {//219
            node.next = result.pop();
            node = node.next;
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
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(0);
        ListNode dummy = rst;
        int carrier = 0;
        //while
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carrier += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carrier += l2.val;
                l2 = l2.next;
            }
            rst.next = new ListNode(carrier % 10);
            carrier = carrier / 10;
            rst = rst.next;
        }
        //check the carrier
        if (carrier == 1) {
            rst.next = new ListNode(1);
        }
        return dummy.next;
    }
}
