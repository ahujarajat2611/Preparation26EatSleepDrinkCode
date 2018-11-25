package smallmomentsmakeitbigger26;

public class PruneBSTOutsideRange {

    // k1 < k2

    public TreeNode pruneBST(TreeNode root, int k1, int k2) {
        if (null == root) {
            return root;
        }
        if (root.val < k1) {
            return pruneBST(root.right, k1, k2);
        }
        if (root.val > k2) {
            return pruneBST(root.left, k1, k2);
        }

        root.left = pruneBST(root.left, k1, k2);
        root.right = pruneBST(root.right, k1, k2);
        return root;
    }
    public TreeNode removeAllHalfNodes(TreeNode root) {
        if (root == null)
            return null;
        root.left = removeAllHalfNodes(root.left);
        root.right = removeAllHalfNodes(root.right);
        if (isHalfNode(root)) {
            return root.left != null ? root.left : root.right;
        }
        return root;
    }

    public boolean isHalfNode(TreeNode root) {
        return (root.left != null && root.right == null) || (root.left == null && root.right != null);
    }
    public TreeNode removeAllLeaves(TreeNode root) {
        if (root == null)
            return null;
        if (isLeave(root)) {
            root = null;
            return root;
        }
        root.left = removeAllLeaves(root.left);
        root.right = removeAllLeaves(root.right);
        return root;
    }

    public boolean isLeave(TreeNode root) {
        return root.left == null && root.right == null;
    }

    int floor = Integer.MIN_VALUE;
    int ceiling = Integer.MAX_VALUE;

    public void floorAndCeilingOfBST(TreeNode root, int key) {
        if (root == null)
            return;
        if (root.val > key) {
            // left jana cleiing
            // note down in recursive
            ceiling = root.val;
            floorAndCeilingOfBST(root.left, key);
        } else if (root.val < key) {
            // right java floor note down its vlaue
            floor = root.val;
            floorAndCeilingOfBST(root.right, key);
        } else {
            ceiling = key;
            floor = key;
        }
    }
    TreeNode predessor = null, sucessor = null;

    public void findPredSucc(TreeNode tree, TreeNode root, int data) {
        if (null == root)
            return;
        if (root.val > data) {
            sucessor = root;
            // i am going left
            // note down this might be successor
            findPredSucc(tree, root.left, data);
        } else if (root.val < data) {
            predessor = root;
            // going right this might be precessor
            findPredSucc(tree, root.right, data);
        } else {
            // if root left is not null, then predessor is max on the left sub
            // tree

            if (root.left != null) {
                predessor = tree.findMax(root.left);
            }

            // if root right is not null, then successor is min on the right sub
            // tree
            if (root.right != null) {
                sucessor = tree.findMin(root.right);
            }
        }

    }

}
