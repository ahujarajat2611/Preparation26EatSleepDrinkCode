package BasicAlgorithms.Heap;
import java.util.*;

/**
 * Created by hadoop on 7/1/18.
 */
public class KthLargestInNArrays {
    class Node {
        int val;
        int from_id;
        int index;
        public Node (int val, int from_id, int index){
            this.val = val;
            this.from_id = from_id;
            this.index = index;
        }
    }
    public class Solution {
        public int KthInArrays(int[][] arrays, int k) {
            Queue<Node> queue = new PriorityQueue<Node>(k, new Comparator<Node>(){
                @Override
                public int compare(Node a, Node b){
                    return b.val - a.val;
                }
            });
            for (int i = 0; i < arrays.length; i++){
                // really nice technique to sort
                // individual array !!!
                Arrays.sort(arrays[i]);
                int l = arrays[i].length;
                if (l == 0){
                    continue;
                }
                queue.offer(new Node(arrays[i][l - 1], i, l - 1));
            }
            for (int i = 0; i < k - 1; i++){
                Node cur = queue.poll();
                int from_id = cur.from_id;
                int index = cur.index;
                if (index > 0){
                    queue.offer(new Node(arrays[from_id][index - 1], from_id, index - 1));
                }
            }
            return queue.poll().val;
        }
    }

}
