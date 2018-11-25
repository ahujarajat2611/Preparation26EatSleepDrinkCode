package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
public class KthSmallestElement {
    class Node {
        int val;
        int x,y;
        public Node(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix[0] == null || matrix.length == 0
                || matrix[0].length == 0 || k <= 0) {
            return -1;
        }

        //Init queue
        PriorityQueue<Node> queue = new PriorityQueue<Node>(k,
                new Comparator<Node>(){
                    public int compare(Node a, Node b) {
                        return a.val - b.val;
                    }
                });

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0) {
                queue.offer(new Node(matrix[i][0], i, 0));
            }
        }

        //Find kth
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(k == 1) {
                return node.val;
            }
            int x = node.x;
            int y = node.y;
            if (y < matrix[x].length - 1) {
                queue.offer(new Node(matrix[x][y+1], x, y+1));
            }
            k--;
        }

        return -1;
    }
}
