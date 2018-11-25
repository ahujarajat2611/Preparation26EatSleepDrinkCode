package BasicAlgorithms.LinkedList;

import java.util.*;
class RandomListNode {
    int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class copyListWithRandomPointer {
	//深拷贝，联想到hashtable,旧节点对应新节点。 第一次遍历把所有node输入进map，第二次遍历连接各个list node.
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode pointer = head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		while (pointer != null) {
			RandomListNode newNode = new RandomListNode(pointer.label);
			map.put(pointer, newNode);
			pointer = pointer.next;
		}
		pointer = head;
		while (pointer != null) {
			RandomListNode newNode = map.get(pointer);

			// assign next
			RandomListNode newNext = map.get(pointer.next);
			// assign nextnode
			newNode.next = newNext;

			// asisgn randome
			if (pointer.random != null) {				
				RandomListNode newRandom = map.get(pointer.random);
				// asisgn random
				newNode.random = newRandom;
			}
			// move forward
			pointer = pointer.next;
		}
		return map.get(head);
	}
	
	//把链表想成图，用bfs+hashmap同样可做，与图不同的是每个节点最多连着两个其他节点，并且是有向的。
	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null)
			return head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		map.put(head, new RandomListNode(head.label));
		Queue<RandomListNode> queue = new LinkedList<RandomListNode>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			RandomListNode n = queue.poll();
			if (n.next != null && !map.containsKey(n.next)) {
				map.put(n.next, new RandomListNode(n.next.label));
				queue.offer(n.next);
			}
			if (n.random != null && !map.containsKey(n.random)) {
				map.put(n.random, new RandomListNode(n.random.label));
				queue.offer(n.random);
			}
			map.get(n).next = map.get(n.next);
			map.get(n).random = map.get(n.random);
		}
		return map.get(head);
	}
}
