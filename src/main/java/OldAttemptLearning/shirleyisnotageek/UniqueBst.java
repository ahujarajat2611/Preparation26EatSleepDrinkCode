package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
According to Binary Search Tree's definition, in order for node i to be the root, it's left subtree can only be generated from node 0 to i - 1, and it's right subtree can only be generated from i + 1 to n.

So, Tree[n] = Tree[0] * Tree[n - 1] + Tree[1] * Tree[n - 2] + ... + Tree[i] * Tree[n - i - 1] + ... + Tree[n - 1] * Tree[0]
 */
public class UniqueBst {
    public class UniqueBST {
        public int numTrees(int n) {
            if (n < 0)
                return 0;
            if (n == 0 || n == 1)
                return 1;
            int[] Tree = new int[n + 1];
            Tree[0] = 1;
            Tree[1] = 1;

            for (int i = 2; i <= n; i++)
            {
                //j represents the left subtree
                for (int j = 0; j < i; j++)
                    Tree[i] += Tree[j] * Tree[i - j - 1];
            }
            return Tree[n];

        }
    }
    /*
    The second problem is derived from the same idea. The only difference is, now we need to use recursion to generate every left and right subtree.

     */
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTreeHelper(1, n);
    }
    private ArrayList<TreeNode> generateTreeHelper(int start, int end)
    {
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();
        //reach to the leaf
        if (start > end)
        {
            rst.add(null);
            return rst;
        }
        for (int i = start; i <= end; i++)
        {
            ArrayList<TreeNode> left = generateTreeHelper(start, i - 1);
            ArrayList<TreeNode> right = generateTreeHelper(i + 1, end);
            for (TreeNode l : left)
            {
                for (TreeNode r : right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }

        }
        return rst;
    }
}

