package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/*
"Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity."

Using a PriorityQueue is a very smart way. The time complexity is n* O(log(lists.size())) where n is the total nodes in all linked lists.
 */
/**
 * Created by hadoop on 20/1/18.
 */
    public class MergeLists {
        public ListNode mergeKLists(List<ListNode> lists) {
            if (lists == null || lists.size() == 0)
                return null;
            PriorityQueue<ListNode> listNodeQueue = new PriorityQueue<ListNode> (lists.size(), new ListNodeComparator());
            for (ListNode node : lists) {
                if (node != null)
                    listNodeQueue.add(node);
            }
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            while (!listNodeQueue.isEmpty()) {
                ListNode toAdd = listNodeQueue.poll();
                head.next = toAdd;
                if (toAdd.next != null)
                    listNodeQueue.add(toAdd.next);
                head = head.next;
            }
            return dummy.next;

        }
        private class ListNodeComparator implements Comparator<ListNode> {
            public int compare (ListNode a, ListNode b) {
                return a.val - b.val;
            }
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
