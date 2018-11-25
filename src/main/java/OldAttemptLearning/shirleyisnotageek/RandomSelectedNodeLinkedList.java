package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 22/1/18.
 */
public class RandomSelectedNodeLinkedList {
    /*
    The probability that the second last node is result
          = [Probability that the second last node replaces result] X
            [Probability that the last node doesn't replace the result]
          = [1 / (N-1)] * [(N-1)/N]
          = 1/N
          1) Count number of nodes by traversing the list.

           Traverse the list again and select every node with probability 1/N. The selection can be done by generating a random number from 0 to N-i for i'th node, and selecting the i'th node node only if generated number is equal to 0 (or any other fixed number from 0 to N-i).

(1) Initialize result as first node
   result = head->key
(2) Initialize n = 2
(3) Now one by one consider all nodes from 2nd node onward.
    (3.a) Generate a random number from 0 to n-1.
         Let the generated random number is j.
    (3.b) If j is equal to 0 (we could choose other fixed number
          between 0 to n-1), then replace result with current node.
    (3.c) n = n+1
    (3.d) current = current->next


     */
    public void selectKSamples(int[] data, int k) {
        int n = data.length;
        if (n < k) return;
        if (n == k) {
            return;
        }

        int[] pool = new int[k];
        for (int i=0; i<k; ++i) {
            pool[i] = data[i];
        }
        // random pick
        for (int i=k; i<n; ++i) {
            int rand = (int)(Math.random() * (i+1)); // generate a random number of [0,i]
            if (rand < k) {
                pool[rand] = data[i];
            }
        }
    }

    public int findMax(int[] array) {
        int len = array.length;
        int result = -1;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == max) {
                count++;
                int num = new Random().nextInt(count);
                if (num == 0) {
                    result = i;
                }
            } else if (max == Integer.MIN_VALUE || array[i] > max) {
                max = array[i];
                result = i;
                count = 1;
            }
        }
        return result;
    }
    public static TreeNode[] randomKSampleTreeNode(TreeNode root, int k){
        TreeNode[] reservoir = new TreeNode[k];
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int index = 0;

        //copy first k elements into reservoir
        while(!queue.isEmpty() && index < k){
            TreeNode node = queue.poll();
            reservoir[index++] = node;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        //for index k+1 to the last node of the tree select random index from (0 to index)
        //if random index is less than k than replace reservoir node at this index by
        //current node
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int j = (int) Math.floor(Math.random()*(index+1));
            index++;

            if(j < k){
                reservoir[j] = node;
            }

            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return reservoir;
    }
}
