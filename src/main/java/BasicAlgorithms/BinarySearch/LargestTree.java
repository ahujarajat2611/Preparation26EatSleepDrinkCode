package BasicAlgorithms.BinarySearch;

import java.util.*;
import smallmomentsmakeitbigger26.TreeNode;

/**
 * Created by hadoop on 25/12/17.
 */
public class LargestTree {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if( root==null ) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while( !queue.isEmpty() ){
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for( int i=0; i<size; i++ ){
                TreeNode temp = queue.poll();
                if( temp.val> max ){
                    max = temp.val;
                }

                if( temp.left != null ){
                    queue.offer(temp.left);
                }
                if( temp.right != null ){
                    queue.offer(temp.right);
                }
            }
            result.add(max);

        }


        return result;
    }
}
