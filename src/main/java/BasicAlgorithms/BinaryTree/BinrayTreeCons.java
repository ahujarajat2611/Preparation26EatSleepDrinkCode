package BasicAlgorithms.BinaryTree;

import smallmomentsmakeitbigger26.TreeNode;

/**
 * Created by hadoop on 25/12/17.
 */
public class BinrayTreeCons {
    public TreeNode str2tree(String s) {
        if (s.equals("")) return null;
        int[] ptr = new int[1];
        ptr[0] = 0;
        return dfs(s, ptr);
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

    int globalindex =0;
    public TreeNode str2treeMine(String s) {
        if(globalindex == s.length()){
            return null;
        }
        int sign = 1;
        if(s.charAt(globalindex) == '-'){
            sign =-1;
            globalindex++;
        }
        int number =0;
        while (globalindex<s.length() && Character.isDigit(s.charAt(globalindex))){
            number = number*10 + Integer.parseInt(""+s.charAt(globalindex));
            globalindex++;
        }
        TreeNode root = new TreeNode(sign*number);
        if(globalindex<s.length() && s.charAt(globalindex) == '('){
            globalindex++;
            root.left = str2treeMine(s);
        }
        if(globalindex<s.length() && s.charAt(globalindex) == ')'){
            globalindex++;
            return root;
        }
        if(globalindex<s.length() && s.charAt(globalindex) == '('){
            globalindex++;
            root.right = str2treeMine(s);
        }
        if(globalindex<s.length() && s.charAt(globalindex) == ')'){
            globalindex++;
            return root;
        }
        return root;
    }
}
