package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class deletenode {
    public class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
