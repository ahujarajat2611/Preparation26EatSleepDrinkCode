package BasicAlgorithms.LinkedList;

/*
 *  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 */
public class reorderList {
    // 链表基本操作，找中点，翻转，插入。
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode mid = findMiddle(head);
		ListNode head2 = mid.next;
		mid.next = null;
		head2 = reverse(head2);
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// If not recusrive .. this is really neat approach to solve this problme ..
		// have clear pointers in place to deal with such things ...
		//
		while (head != null && head2 != null) {
			ListNode tmp1 = head.next;
			ListNode tmp2 = head2.next;
			head.next = head2;
			head2.next = tmp1;
			head = tmp1;
			head2 = tmp2;
		}
		head = dummy.next;
	}

	private ListNode findMiddle(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null) {
			runner = runner.next.next;
			walker = walker.next;
		}
		return walker;
	}

	private ListNode reverse(ListNode head) {
		ListNode post = head;
		ListNode pre = null;
		while (post != null) {
			ListNode tmp = post.next;
			post.next = pre;
			pre = post;
			post = tmp;
		}
		return pre;
	}
}
