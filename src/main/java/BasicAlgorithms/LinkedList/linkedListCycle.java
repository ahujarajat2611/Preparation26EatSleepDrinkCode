package BasicAlgorithms.LinkedList;

public class linkedListCycle {
    /*
	 * Given a linked list, determine if it has a cycle in it. Follow up: Can
	 * you solve it without using extra space?
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null) {
			runner = runner.next.next;
			walker = walker.next;

			if (runner == walker)
				return true;
		}
		return false;
	}

}
