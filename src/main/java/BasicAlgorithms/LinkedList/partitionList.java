package BasicAlgorithms.LinkedList;

public class partitionList {
    public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;

		ListNode smallDummy = new ListNode(0);
		ListNode largeDummy = new ListNode(0);

		ListNode small = smallDummy, large = largeDummy;

		while (head != null) {
			if (head.val < x) {
				small.next = head;
				small = small.next;
			} else {
				large.next = head;
				large = large.next;
			}
			head = head.next;
		}
		large.next = null;

		small.next = largeDummy.next;

		return smallDummy.next;
	}
}
