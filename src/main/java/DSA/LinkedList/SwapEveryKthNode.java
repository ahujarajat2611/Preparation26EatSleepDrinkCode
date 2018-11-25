/**
 * 
 */
package DSA.LinkedList;


import DSA.Common.CommonUtil;
import DSA.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class SwapEveryKthNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(11);
		obj.insert(12);
		obj.insert(13);
		obj.insert(14);
		obj.insert(15);
		obj.insert(16);
		obj.insert(17);
		obj.insert(18);
		obj.insert(19);
		obj.insert(20);
		obj.insert(21);
		obj.insert(22);
		obj.insert(23);
		obj.insert(24);
		obj.insert(25);
		obj.insert(26);
		obj.insert(27);

		SwapEveryKthNode ob = new SwapEveryKthNode();
		obj.print();

		int k = 4;
		// Time : O(n)
		obj.root = ob.swapEveryKthNode(obj.root, k);
		obj.print();

	}
//14 12 13 11 18 16 17 15 22 20 21 19 26 24 25 23 27
//14 12 13 11 18 16 17 15 22 20 21 19 26 24 25 23 27


	public ListNode<Integer> swapEveryKthNode(ListNode<Integer> root, int k) {
		ListNode<Integer> cur = root, prev = null;
		int count = 1;
		while (cur != null && count <= k) {
			prev = cur;
			cur = cur.next;
			if (++count > k)
				CommonUtil.swap(prev, root);
		}

		if (cur != null) {
			prev.next = swapEveryKthNode(cur, k);
		}
		return root;
	}

	public ListNode<Integer> swapEveryKthNodeAgain(ListNode<Integer> root, int k) {
		ListNode<Integer> cur = root, prev = null,prepre = null;
		int count = 1;
		while (cur != null && count <= k) {
			prepre = prev;
			prev = cur;
			cur = cur.next;
			if (++count > k) {
				prev.next = root.next;
				prepre.next = root;
				//	CommonUtil.swap(prev, root);
			}
		}

		if (cur != null) {
			root.next = swapEveryKthNode(cur, k);
		}
		return prev;
	}
}
