package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class MergeKSortedLists {

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue =
                new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
                    public int compare(ListNode a, ListNode b){
                        return a.val - b.val;
                    }
                });

        //populate queue with k lists' header
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                queue.offer(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            node.next = curr;

            if (curr.next != null) {
                queue.offer(curr.next);
            }

            node = node.next;
        }

        return dummy.next;
    }
}
