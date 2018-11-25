package DSA.trees.binary;

/**
 * Created by hadoop on 22/2/18.
 */
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s.equals("")) return null;
        int []ptr = new int[1];
        ptr[0]=0;
        return dfs(s,ptr);
    }


    private TreeNode dfs(String s, int[] ptr) {
        long num = 0, sign = 1;
        if (s.charAt(ptr[0]) == '-') {
            sign = -1;
            ptr[0]++;
        }
        while (ptr[0] < s.length() && Character.isDigit(s.charAt(ptr[0])))
            num = num * 10 + s.charAt(ptr[0]++) - '0';
        TreeNode root = new TreeNode((int) (num * sign));
        if (ptr[0] < s.length() && s.charAt(ptr[0]) == '(') {
            ptr[0]++;
            root.left = dfs(s, ptr);
        }
        if (ptr[0] < s.length() && s.charAt(ptr[0]) == ')') {
            ptr[0]++;
            return root;
        }
        if (ptr[0] < s.length() && s.charAt(ptr[0]) == '(') {
            ptr[0]++;
            root.right = dfs(s, ptr);
        }
        if (ptr[0] < s.length() && s.charAt(ptr[0]) == ')') {
            ptr[0]++;
            return root;
        }
        return root;
    }
}
