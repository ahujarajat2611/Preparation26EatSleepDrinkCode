package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
given two nodes of a binary tree, find number of nodes on the path between the two nodes.

      1
     2  3
   4      5

   4, 3 -> (4-2-1-3): 4

       1
     2  3
   4      5

   4, 3 -> (4-2-1-3): 4


Update 2015 - 04 - 05:
Thanks for the comment, I realized that this can be done using in order traversal in one pass. And the code is much simpler.
 */
public class NumberOfNodesBetween2Nodes {
    public int numberOfNodes2(TreeNode root, TreeNode n1, TreeNode n2){
        return inOrder(root, n1, n2, false, false, 0);
    }
    private int inOrder(TreeNode root, TreeNode n1, TreeNode n2, boolean first, boolean second, int sum){
        if(root == null|| second == true)
            return 0;
        sum = inOrder(root.left, n1, n2, first, second, sum);
        if(root == n1)
            first = true;
        if(root == n2)
            second = true;
        if(first == true && second == false)
            sum++;
        sum = inOrder(root.right, n1, n2, first, second, sum);
        return sum;
    }
    /*

I use a common ancestor approach. Find the common ancestor first, then find number of nodes from the ancestor to one node and the other one. The nodes between those two nodes are the sum of two paths minus the double count of the ancestor.

Right now my code needs to go through the tree twice: find the ancestor and get the depth. I am looking for a way to reduce it to one pass...
     */
    public static int numberNodes(TreeNode root, TreeNode n1, TreeNode n2){
        if(n1 == null || n2 == null)
            throw new NullPointerException("Null tree node!");
        if(n1 == n2)
            return 1;
        TreeNode commonAncestor = getAncestor(root, n1, n2);
        return getDepth(commonAncestor, n1) + getDepth(commonAncestor, n2) - 1;
    }
    private static int getDepth(TreeNode root, TreeNode n){
        if(root == null)
            return Integer.MAX_VALUE / 2;
        if(root == n)
            return 1;
        if(root.left == n || root.right == n)
            return 2;
        return Math.min(getDepth(root.left, n), getDepth(root.right,n)) + 1;
    }
    private static TreeNode getAncestor(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null || n1 == null || n2 == null)
            return null;
        if(isChild(root.left, n1) && isChild(root.left, n2))
            return getAncestor(root.left, n1, n2);
        if(isChild(root.right, n1) && isChild(root.right, n2))
            return getAncestor(root.right, n1, n2);
        return root;
    }
    private static boolean isChild(TreeNode root, TreeNode n){
        if(root == null)
            return false;
        if(root == n)
            return true;
        return isChild(root.left, n) || isChild(root.right, n);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n6;
        n3.right = n5;
        System.out.println(numberNodes(n1, n4, n4));

    }
}
