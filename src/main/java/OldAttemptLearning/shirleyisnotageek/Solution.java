package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 31/8/17.
 */
public class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public static void main(String[] args) {

    }
    public ListNode reversebetweenmandn(ListNode head, int m , int n){
        if(head == null){
            return  null;
        }
        if( m == n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int index = m;
        ListNode prelabel = dummy;

        for(index = 1;index<m;index++){
            prelabel = head;
            head = head.next;
            if( head == null){
                return null;
            }
        }
        ListNode current = head;
        ListNode prev = prelabel;
      //  ListNode label = head;
        ListNode temp ;
        for( index = m+1;index<=n;index++){
            temp  = current.next;
            current.next = prev;
            prelabel.next = current;
            prev = current;
            current= temp;
        }
        head.next = current;
        return dummy.next;
    }
}
