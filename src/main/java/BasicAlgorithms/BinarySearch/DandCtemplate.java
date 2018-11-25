package BasicAlgorithms.BinarySearch;

import java.util.ArrayList;

/**
 * Created by hadoop on 17/10/17.
 */
public class DandCtemplate {

    public ArrayList<Integer> preorderTraversal(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        ArrayList<Integer> left = preorderTraversal(node.left);
        ArrayList<Integer> right = preorderTraversal(node.right);

        result.add(node.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    private static class ResultType {
        int currentPath;
        int maxpath;

        ResultType(int currentPath, int maxpath) {
            this.maxpath = maxpath;
            this.currentPath = currentPath;
        }

        ResultType() {

        }

        @Override
        public String toString() {
            return "ResultType{" +
                    "currentPath=" + currentPath +
                    ", maxpath=" + maxpath +
                    '}';
        }
    }

    public ResultType traversal(TreeNode node) {
        // nulll or leaf depends wt questions
        if (node == null) {
            return new ResultType();
        }

        ResultType left = traversal(node.left);
        ResultType right = traversal(node.right);
        // conquer
        // Merge from left and right
        ResultType result = null; // merge from left and right ( merge)
        return result;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return maxDepthHelper(node);
    }

    public int maxDepthHelper(TreeNode node) {

//         if(root == null){
//             return 0;
//         }

//         LinkedList<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int level =0;
//         while (!queue.isEmpty()){
//             int size  =queue.size();
//             for(int i=0;i<size;i++){
//                 TreeNode polled = queue.poll();
//                 if(polled.left!=null){
//                     queue.add(polled.left);
//                 }
//                 if(polled.right!=null){
//                     queue.add(polled.right);
//                 }
//             }
//             level++;
//         }
//         return level;
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int lefheight = maxDepthHelper(node.left);
        int rigthheight = maxDepthHelper(node.right);

        int result = 1;
        result = result + Math.max(lefheight, rigthheight);
        return result;

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepthHelper(root);
    }

    public int minDepthHelper(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int lefheight = minDepthHelper(node.left);
        int rigthheight = minDepthHelper(node.right);

        int result = 1;
        result = result + Math.min(lefheight, rigthheight);
        return result;

    }

    public boolean isbalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int ans = isbalancedHelper(node);
        return ans != -1;
    }

    private int isbalancedHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int leftheight = isbalancedHelper(node.left);
        int rightheight = isbalancedHelper(node.right);

        if (leftheight == -1) {
            return -1;
        }
        if (rightheight == -1) {
            return -1;
        }
        int diff = Math.abs(leftheight - rightheight);
        if (diff < 2) {
            return Math.max(leftheight, rightheight) + 1;
        }
        return -1;
    }

    public static int maxpath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        ResultType resultType = maxPathHelper(node);
        return resultType.maxpath;
    }

    private static ResultType maxPathHelper(TreeNode node) {
        System.out.println("here1");
        if (node == null) {
            System.out.println("here");

            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        if (node.right == null && node.left == null) {
            System.out.println("here");

            return new ResultType(node.val, node.val);
        }
        System.out.println("here");

        ResultType left = maxPathHelper(node.left);
        ResultType right = maxPathHelper(node.right);
        System.out.println("left" + left);
        System.out.println("right" + right);
        System.out.println("node" + node.val);


        int currentPath = Math.max(node.val, Math.max(left.currentPath, right.currentPath) + node.val);
        int maxpath = Math.max(left.maxpath, Math.max(right.maxpath, node.val +

                (right.currentPath != Integer.MIN_VALUE ? right.currentPath : 0) +
                (left.currentPath != Integer.MIN_VALUE ? left.currentPath : 0)));
        System.out.println("currentPath" + currentPath);
        System.out.println("maxpath" + maxpath);
        return new ResultType(currentPath, maxpath);
    }


    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        System.out.println(maxpath(node));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val <= p.val && root.val >= q.val) {
            return root;
        } else if (root.val <= q.val && root.val >= p.val) {
            return root;
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return root;
        }
        if (root == q) {
            return root;
        }
        TreeNode left = commonAncestor(root.left, p, q);
        TreeNode right = commonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
