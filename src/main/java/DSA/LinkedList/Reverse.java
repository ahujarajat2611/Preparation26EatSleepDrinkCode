/**
 * 
 */
package DSA.LinkedList;


import DSA.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class Reverse {

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

		Reverse ob = new Reverse();
		obj.print();
		ob.reverse(obj);
		obj.print();
		obj.root = ob.reverse(obj.root, null);
		obj.print();
	}

	public ListNode<Integer> reverse(ListNode<Integer> root, ListNode<Integer> prev) {
		if (root == null) {
			return root;
		}
		ListNode<Integer> next = root.next;
		root.next = prev;
		if (next == null)
			return root;
		return reverse(next, root);
	}

	// Time : O(n)
	public void reverse(SingleLinkedList<Integer> obj) {
		ListNode<Integer> cur, next, prev;
		cur = obj.root;
		prev = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		obj.root = prev;
	}

}
