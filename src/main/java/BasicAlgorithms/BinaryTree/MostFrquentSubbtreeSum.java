package BasicAlgorithms.BinaryTree;

import java.util.HashMap;
import java.util.*;

/**
 * Created by hadoop on 25/12/17.
 */
public class MostFrquentSubbtreeSum {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int maxf = 1;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer sum = dfs(root.left) + dfs(root.right) + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if(maxf<map.get(sum)){
            maxf = map.get(sum);
        }
        return sum;
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() == maxf){
                list.add(entry.getKey());
            }
        }
        int []res = new int[list.size()];
        int i = 0;
        for(int a:list){
            res[i++] = a;
        }
        return res;
    }
}