package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode dummyPre = new ListNode(0);
        ListNode dummyPost = new ListNode(0);
        ListNode pre = dummyPre;
        ListNode post = dummyPost;

        while (head != null) {
            if (head.val < x) {
                pre.next = head;
                pre = pre.next;
            } else {
                post.next = head;
                post = post.next;
            }
            head = head.next;
        }

        post.next = null;
        pre.next = dummyPost.next;

        return dummyPre.next;
    }
}
