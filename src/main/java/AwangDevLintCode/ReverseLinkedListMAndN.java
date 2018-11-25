package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
/*
Thinking process:
0. Use dummy node to store head
1. Find mNode, store the front nodes
2. Reverse from mNode to nNode
3. Link front, middle, end nodes together
Note, when doing reverse, always:
    - reversedList = 1st item
    - postNode = 2nd item
    - store 3rd item in temp: temp = postNode.next
*/
public class ReverseLinkedListMAndN {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        ListNode nodeFront = null;


        for (int countM = 1; countM < m; countM++) {
            if (head == null) {
                return head;
            }
            head = head.next;
        }
        nodeFront = head;
        // very very imp save the head of reverselist to be used
        // later
        ListNode mNode = head.next; //Head is Mth node. Reserve it
        ListNode reversedList = mNode;
        ListNode postNode = mNode.next;
        for (int countN = m; countN < n; countN++) {
            ListNode temp = postNode.next;
            postNode.next = reversedList;
            reversedList = postNode;
            postNode = temp;
        }
        //List front, middle and end section
        nodeFront.next = reversedList;
        mNode.next = postNode;
        return dummyNode.next;
    }
}
