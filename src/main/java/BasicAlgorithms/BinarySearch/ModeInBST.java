package BasicAlgorithms.BinarySearch;
import smallmomentsmakeitbigger26.TreeNode;

import java.util.*;

/**
 * Created by hadoop on 24/12/17.
 */
public class ModeInBST {
    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
            // if there are more than one mode(highest frequency element
            // then keep both in the answer
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
}
/*
//      public int[] findMode(TreeNode root) {
//         if (root == null) return new int[0];
//         Map<Integer, Integer> map = new HashMap<>();
//         dfs(root, map);
//         int maxFrequency = 0;
//         for (int frequency : map.values()) maxFrequency = Math.max(maxFrequency, frequency);
//         List<Integer> modes = new ArrayList<>();
//         for (int key : map.keySet()) if (map.get(key) == maxFrequency) modes.add(key);
//         return modes.stream().mapToInt(i -> i).toArray();
//     }

//     private void dfs(TreeNode root, Map<Integer, Integer> map) {
//         if (root == null) return;
//         map.put(root.val, map.getOrDefault(root.val, 0) + 1);
//         dfs(root.left, map);
//         dfs(root.right, map);
//     }
 */