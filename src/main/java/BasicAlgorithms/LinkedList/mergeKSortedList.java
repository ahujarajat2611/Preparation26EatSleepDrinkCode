package BasicAlgorithms.LinkedList;

import java.util.*;

//利用merge sort的思想，分治，把list分为两半，直到只剩2个list然后合并。
//我们来分析一下上述算法的时间复杂度。假设总共有k个list，每个list的最大长度是n，那么运行时间满足递推式T(k) = 2T(k/2)+O(n*k)。
//根据主定理，可以算出算法的总复杂度是O(nklogk)。如果不了解主定理的朋友，可以参见主定理-维基百科。空间复杂度的话是递归栈的大小O(logk)。
public class mergeKSortedList {
    public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return helper(lists, 0, lists.size() - 1);
	}

	private ListNode helper(List<ListNode> lists, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			ListNode left = helper(lists, l, m);
			ListNode right = helper(lists, m + 1, r);
			return merge(left, right);
		}
		return lists.get(l);
	}

	private ListNode merge(ListNode n1, ListNode n2) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				pre.next = n1;
				n1 = n1.next;
			} else {
				pre.next = n2;
				n2 = n2.next;
			}
			pre = pre.next;
		}
		if (n1 != null) {
			pre.next = n1;
		} else {
			pre.next = n2;
		}
		return dummy.next;
	}

	// 利用堆的性质，依次把最小元素放入堆中
	public ListNode mergeKLists2(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,
				new Comparator<ListNode>() {
					public int compare(ListNode n1, ListNode n2) {
						return n1.val - n2.val;
					}
				});
		for (ListNode n : lists) {
			heap.offer(n);
		}
		ListNode head = null;
		ListNode pre = null;
		while (!heap.isEmpty()) {
			ListNode cur = heap.poll();
			if (head == null) {
				head = cur;
				pre = head;
			} else {
				pre.next = cur;
				pre = cur;
			}
			if (cur.next != null) {
				heap.offer(cur.next);
			}
		}
		return head;
	}
}
