package OldAttemptLearning.shirleyisnotageek;

/*
"Sort a linked list using insertion sort."
3 -> 1 -> 12 -> 6

dummy(0) -> null
dummy(0) -> 3 -> null
dummy(0) -> 1 -> 3 -> null
dummy(0) -> 1 -> 3 -> 12 -> null
dummy(0) -> 1 -> 3 -> 6 -> 12 -> null
 */
class InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        // insert into dummynod e
        // take each node from head
        // then lisnked list inertion into dummy new list

        while (head != null)
        {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val)
                node = node.next;
            ListNode tmp = head.next;
            head.next = node.next;
            node.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}