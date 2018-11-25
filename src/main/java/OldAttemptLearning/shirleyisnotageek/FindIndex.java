package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 24/1/18.
 */
class LinkedListNode {
        String val;
        LinkedListNode next;
        LinkedListNode(String val){
            this.val = val;
        }

}


public class FindIndex {
    static int find(LinkedListNode list, LinkedListNode sublist) {
        LinkedListNode firstList = list;
        int index = 0;
        while (firstList!=null){
            if(firstList.val == sublist.val){
                LinkedListNode first = firstList;
                LinkedListNode second = sublist;
                System.out.println("first "+first.val);
                System.out.println("second "+second.val);
                while (second!=null && first!=null && second.val == first.val){
                    second = second.next;
                    first = first.next;
                }
                if(second == null){
                    return index;
                }
            }
            firstList = firstList.next;
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode("1");
        LinkedListNode second = new LinkedListNode("2");
        LinkedListNode three = new LinkedListNode("3");
       // LinkedListNode four = new LinkedListNode("4");
       // LinkedListNode five = new LinkedListNode("5");

        first.next = second;
        second.next = three;
       // three.next = four;
        //four.next = five;

        LinkedListNode three_sub = new LinkedListNode("1");
        LinkedListNode four_sub = new LinkedListNode("3");
       // LinkedListNode five_sub = new LinkedListNode("5");
        three_sub.next = four_sub;
      //  four_sub.next = five_sub;
        System.out.println(find(first,three_sub));

    }
    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val){
        if(head == null) {
            head = new LinkedListNode(val);
        }
        else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }
}
