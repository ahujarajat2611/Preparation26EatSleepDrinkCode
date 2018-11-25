package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class MergeKSortedArrays {
    public class Node {
        int val, x, y;
        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> rst = new ArrayList<Integer>();
        if (arrays == null || arrays.length == 0) {
            return rst;
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>(arrays.length,
                new Comparator<Node>() {
                    public int compare(Node a, Node b){
                        return a.val - b.val;
                    }
                }
        );

        //init
        for (int i = 0; i < arrays.length; i++) {
            // inserted all rows and first coolumn of all rows
            if (arrays[i].length != 0) {
                queue.offer(new Node(arrays[i][0], i, 0));
            }
        }

        Node node;

        while (!queue.isEmpty()) {
            node = queue.poll();
            rst.add(node.val);
            // just wowww
            // currencollumn + 1 < length[row].length
            if (node.y +1< arrays[node.x].length) {
                queue.offer(new Node(arrays[node.x][node.y + 1], node.x, node.y + 1));
            }
        }

        return rst;

    }
}
