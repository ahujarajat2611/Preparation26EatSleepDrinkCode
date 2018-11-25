package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 20/9/17.
 */
public class AddLists {
    int base = 10;
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    ListNode addLists(ListNode a,ListNode b){
        int carry=0;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (a!=null && b!=null){
            int sum = carry + a.val + b.val;
                carry = sum/base;
                int nodevalue = sum%base;
                tail.next = new ListNode(nodevalue);
                tail = tail.next;
                a = a.next;
                b = b.next;
        }
        while (a!=null){
            int sum = carry+a.val;
            carry = sum/base;
            int nodevalue = sum%base;
            tail.next = new ListNode(nodevalue);
            tail = tail.next;
            a = a.next;
        }

        while (b!=null){
            int sum = carry+b.val;
            carry = sum/base;
            int nodevalue = sum%base;
            tail.next = new ListNode(nodevalue);
            tail = tail.next;
            b = b.next;
        }
        if(carry!=0){
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        return dummy.next;
    }
    public static void main(String args[]){
        AddLists addLists = new AddLists();
        //addLists.addLists();
    }
    public ListNode shortListNode(ListNode a,ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry =0;
        while(a!=null || b!=null || carry!=0){
            int num1=0;
            if(a!=null){
                num1 = a.val;
                a = a.next;
            }
            int num2 = 0;
            if(b!=null){
                num2 = b.val;
                b = b.next;
            }
            carry = carry + num1+num2;
            tail.next = new ListNode(carry%base);
            carry = carry/base;
            tail = tail.next;
        }
        return dummy.next;
    }
}
