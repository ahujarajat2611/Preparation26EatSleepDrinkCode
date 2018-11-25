package BasicAlgorithms.LinkedList;

public class mergeTwoSortedLists {
    //此题比较简单，可以设定三个指针，一个指针为新链表指针，另外两个分别指向l1,l2
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		if (l1 != null) {
			pre.next = l1;
		} else {
			pre.next = l2;
		}
		return dummy.next;
	}
}
