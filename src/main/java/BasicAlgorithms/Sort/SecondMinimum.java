package BasicAlgorithms.Sort;

/**
 * Created by hadoop on 11/11/17.
 */
public class SecondMinimum {
    public static Integer secondMin(Node root) {
        if(root.left == null || root.right == null) return Integer.MAX_VALUE;
        int min;
        if(root.left.val == root.val) {
            min = Math.min(root.right.val, secondMin(root.left));
        } else {
            min = Math.min(root.left.val, secondMin(root.right));
        }

        return min;
    }
    private class Node{
        Node left;
        Node right;
        int val;
    }
}
