package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        //creat node, used to link all nodes
        RandomListNode node = new RandomListNode(0);
        RandomListNode dummy = node;

        //HashMap to mark node
        // here dummy node is very imp  ..
        // very nicely created nodes of head.label  and random nodes as well !!!

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        while(head != null) {
            //process head. (we already know head!=null)
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.label));
            }
            node.next = map.get(head);
            //process head.random
            if (head.random != null) {
                if(!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.label));
                }
                node.next.random = map.get(head.random);
            }
            node = node.next;
            head = head.next;
        }
        return dummy.next;
    }
}
