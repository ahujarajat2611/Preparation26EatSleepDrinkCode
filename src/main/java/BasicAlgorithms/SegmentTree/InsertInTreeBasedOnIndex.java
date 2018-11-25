package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 25/10/17.
 */
import java.util.*;
public class InsertInTreeBasedOnIndex {
    private class Solution {
        // with array insert: 18ms, 86%
        // with tree: 21ms, 61%
        public int[][] reconstructQueue(int[][] people) {
            if (people.length <= 1) return people;
            // sort height in descending order (same height: sort position in ascending order)
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] != b[0] ? b[0] - a[0] : a[1] - b[1];
                }
            });
        /*
        List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            res[i] = list.get(i);
        }
        */
            // add to tree according to its position/rank
            TreeNode root = new TreeNode(people[0]);
            for (int i = 1; i < people.length; i++) {
                addToTree(root, people[i], people[i][1]);
            }
            // inoder traversal
            int[][] res = new int[people.length][2];
            dfs(root, res, new int[1]);
            return res;
        }

        private void dfs(TreeNode node, int[][] res, int[] i) {
            if (node == null) return;
            dfs(node.left, res, i);
            res[i[0]] = node.val;
            i[0]++;
            dfs(node.right, res, i);
        }

        private void addToTree(TreeNode root, int[] curr, int pos) {
            TreeNode node = root;
            while (node != null) {
                node.size++;
                if (pos <= sizeOf(node.left)) {
                    if (node.left == null) {
                        node.left = new TreeNode(curr);
                        break;
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new TreeNode(curr);
                        break;
                    }
                    pos -= sizeOf(node.left) + 1;
                    node = node.right;
                }
            }
        }

        private int sizeOf(TreeNode node) {
            return node == null ? 0 : node.size;
        }
    }

    class TreeNode {
        int[] val;
        int size;
        TreeNode left, right;
        public TreeNode(int[] v) {
            val = v;
            size = 1;
        }
    }
}
