package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
public class
HashMapDeepCopy {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public class CopyList {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null)
                return null;
            RandomListNode dummy = new RandomListNode(0);
            RandomListNode pre = dummy;
            RandomListNode newNode;
            HashMap<RandomListNode,RandomListNode> hm = new HashMap<RandomListNode,RandomListNode>();
            while (head != null)
            {
                if (hm.containsKey(head))
                    newNode = hm.get(head);
                else
                {
                    newNode = new RandomListNode(head.label);
                    hm.put(head, newNode);
                }
                if (head.random != null)
                {
                    if (hm.containsKey(head.random))
                        newNode.random = hm.get(head.random);
                    else
                    {
                        newNode.random = new RandomListNode(head.random.label);
                        hm.put(head.random, newNode.random);
                    }
                }
                pre.next = newNode;
                pre = newNode;
                head = head.next;
            }
            return dummy.next;
        }
    }
}
